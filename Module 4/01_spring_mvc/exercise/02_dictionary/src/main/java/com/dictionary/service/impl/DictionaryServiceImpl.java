package com.dictionary.service.impl;

import com.dictionary.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    Map<String,String> englishToVietnamese = new HashMap<>();
    @Override
    public String translate(String englishWord) {
        englishToVietnamese.put("go","đi");
        englishToVietnamese.put("sleep","ngủ");
        englishToVietnamese.put("eat","ăn");
        englishToVietnamese.put("study","học");
        englishToVietnamese.put("dance","nhảy");
        englishToVietnamese.put("laugh","cười");
        String result;
        boolean contain = englishToVietnamese.containsKey(englishWord.toLowerCase());
        if (contain) {
            result = englishWord + " translates to Vietnamese: " + englishToVietnamese.get(englishWord.toLowerCase());
        } else {
            result = "Couldn't find the word " + englishWord + " in our dictionary's data!";
        }
        return result;
    }
}
