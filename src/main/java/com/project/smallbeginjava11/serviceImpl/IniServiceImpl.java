package com.project.smallbeginjava11.serviceImpl;

import com.project.smallbeginjava11.DTO.*;
import com.project.smallbeginjava11.mapper.IniMapper;
import com.project.smallbeginjava11.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class IniServiceImpl implements IniService{

    private final IniMapper iniMapper;
    private final DateListService dateListService;
    private final MonthListService monthListService;
    private final IniDetailService iniDetailService;
    private final IniDetailAddService iniDetailAddService;
    private final PossibleDateService possibleDateService;


    // Initiative가 입력된 다음 MonthListCode나 DateListCode를 가져온다.
    @Override
    public Initiative getDateListCodeOrMonthListCode(Map<String, Object> map) throws ParseException {
        return iniMapper.selectMaxIniByObCode(map);
    }

    //Initiative가 입력된 다음 해당 IniCode를 반환한다.
    @Override
    public Initiative getRecentIniCodeByObCode(Map <String, Object> map) throws ParseException {
        return iniMapper.selectMaxIniByObCode(map);
    }

    @Override
    public void insertIni(Map<String, Object> params) throws ParseException {
        iniMapper.insertIni(params);
        Initiative iniByObCode = iniMapper.selectMaxIniByObCode(params);
        params.put("iniCode", iniByObCode.getIniCode());

        // String monthListCode = String.valueOf(iniByObCode.getMonthListCode());
        String dateListCode = String.valueOf(iniByObCode.getDateListCode());

        int iniPeriod = (int) params.get("iniPeriod");
        possibleDateService.insertPossibleDateList(params);

        //  주 단위일 때
        if (iniPeriod == 1){
            params.put("dateListCode", dateListCode);
            dateListService.insertDateList(params);

            Initiative iniForDetail = iniDetailService.calculateWeeks(params);

            for (IniDetail iniDetail : iniForDetail.getIniDetails()){
                System.out.println(iniDetail);
            }

            List<PossibleDate> possibleDateList = possibleDateService.fromDateListToPossibleDateList(iniForDetail);
            params.put("possibleDateList", possibleDateList);

            System.out.println("1) possibleDateList : ****************************");
            possibleDateList.forEach(possibleDate -> System.out.println(possibleDate.getPsbDt()));
            System.out.println("****************************");

            possibleDateService.insertPossibleDate(params);
            List<PossibleDate> possibleDateCodeList = possibleDateService.selectPossibleDateCodeByIniCode(params);
            params.put("possibleDateCodeList", possibleDateCodeList);

            System.out.println("2) possibleDateCodeList : ****************************");
            possibleDateCodeList.forEach(possibleDate -> System.out.println(possibleDate.getPsbDtCode()));
            System.out.println("****************************");

            params.put("iniPossibleCount", String.valueOf(iniForDetail.getIniPossibleCount()));
            params.put("iniDetails", iniForDetail.getIniDetails());
            possibleDateList.forEach(possibleDate -> System.out.println(possibleDate));
            iniDetailService.insertIniDetail(params);

            List<Integer> iniDtlCodeList = iniDetailService.selectIniDtlCodes(params);
            params.put("iniDtlCodeList", iniDtlCodeList);
            List<Integer> iniDtlCountList = iniDetailAddService.calculateDaysInclude(iniForDetail, iniDtlCodeList);
            params.put("iniDtlCountList", iniDtlCountList);

            System.out.println("3) iniDtlCountList : ****************************");
            iniDtlCountList.forEach(y -> System.out.println(y));
            System.out.println("****************************");

            List<IniDetailAdd> iniDtlAddList = iniDetailAddService.combineIniDtlCodeAndPossibleDate(params);
            params.put("iniDtlAddList", iniDtlAddList);

            iniDetailAddService.insertIniDetailAdd(params);


        //  월 단위일 때
        } else if(iniPeriod == 2){
            // params.put("monthListCode", monthListCode);
            List<IniDetail> iniDetails = iniDetailService.calculateMonths(params);
            params.put("iniDetails", iniDetails);

            List<PossibleDate> possibleDateList = possibleDateService.convertFromDateToPossibleDate(params);
            params.put("possibleDateList", possibleDateList);
            possibleDateService.insertPossibleDate(params);

            // System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            iniDetails.forEach(x -> System.out.println(x));
            // System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

            iniDetailService.insertIniDetail(params);
            // iniDetailService.getDayOfMonth(iniDetails, params);

            List<Integer> iniDtlCodeList = iniDetailService.selectIniDtlCodes(params);

            System.out.println("1) $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            iniDtlCodeList.forEach(x -> System.out.println(x));
            params.put("iniDtlCodeList", iniDtlCodeList);
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");


            List<IniDetailAdd> iniDtlAddList = iniDetailAddService.combineIniDtlCodeAndIniDtlAdd(params);
            System.out.println("3) $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            iniDtlAddList.forEach(x -> System.out.println(x));
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");



            params.put("iniDtlAddList", iniDtlAddList);

            iniDetailAddService.insertIniDetailAdd(params);


        }
    }


}
