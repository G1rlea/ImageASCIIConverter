package com.company.imageio.writer;


import com.company.asciiconverter.abst.AsciiConverter;
import com.company.imageio.reader.ImageReader;
import com.company.imageio.writer.abst.AsciiWriter;
import com.company.rgbcalculator.EyeSensitiveRgbValueCalculator;
import lombok.Builder;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


public class TelegramBotAsciiWriter extends TelegramLongPollingBot implements AsciiWriter {

    private static final String TELEGRAM_BOT_TOKEN = "5225026804:AAEwla5uq3896RYXdlCJu297DdLmtNP37UA";
    private static final String TELEGRAM_BOT_NAME = "ImageAscii_bot";
    private final AsciiConverter asciiConverter;

    @Builder
    public TelegramBotAsciiWriter(AsciiConverter asciiConverter) {
        this.asciiConverter = asciiConverter;
    }


    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        ImageReader reader = ImageReader.builder()
                .calculator(new EyeSensitiveRgbValueCalculator())
                .filePath("C:\\Users\\Adrian\\IdeaProjects\\ImageASCIIConverter\\assets\\img\\img.png")
                .build();

        writeAsciiImage(reader.getRgbValueArray());
    }

    @Override
    public void writeAsciiImage(int[][] arr) {
        for (var row: arr) {
            for (int element: row){
                System.out.print(asciiConverter.getChar(element));
            }
            System.out.println();
        }
    }

    @Override
    public String getBotUsername() {
        return TELEGRAM_BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return TELEGRAM_BOT_TOKEN;
    }

}
