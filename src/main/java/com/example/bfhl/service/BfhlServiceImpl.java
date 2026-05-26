package com.example.bfhl.service;

import com.example.bfhl.dto.RequestDto;
import com.example.bfhl.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Override
    public ResponseDto processData(RequestDto request) {

        List<String> odd = new ArrayList<>();
        List<String> even = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> special = new ArrayList<>();

        int sum = 0;
        StringBuilder allChars = new StringBuilder();

        for (String str : request.getData()) {

            if (str.matches("\\d+")) {

                int num = Integer.parseInt(str);

                sum += num;

                if (num % 2 == 0) {
                    even.add(str);
                } else {
                    odd.add(str);
                }

            } else if (str.matches("[a-zA-Z]+")) {

                alphabets.add(str.toUpperCase());
                allChars.append(str);

            } else {

                special.add(str);
            }
        }

        String concat = buildConcatString(allChars.toString());

        return new ResponseDto(
                true,
                "rishika_billore_02072006",
                "rishikabillore230884@acropolis.in",
                "0827CI231110",
                odd,
                even,
                alphabets,
                special,
                String.valueOf(sum),
                concat
        );
    }

    private String buildConcatString(String input) {

        String reversed = new StringBuilder(input).reverse().toString();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < reversed.length(); i++) {

            char ch = reversed.charAt(i);

            if (i % 2 == 0) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(Character.toLowerCase(ch));
            }
        }

        return result.toString();
    }
}
