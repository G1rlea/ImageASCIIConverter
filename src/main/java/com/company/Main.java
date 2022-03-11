package com.company;

import com.company.asciiconverter.BasicAsciiConverter;
import com.company.asciiconverter.data.AsciiCharactersDensity;
import com.company.imageio.writer.TelegramBotAsciiWriter;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
//        ImageAsciiConverter.convert("assets/img/img.png");
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TelegramBotAsciiWriter(new BasicAsciiConverter(AsciiCharactersDensity.LOW_DENSITY)));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
