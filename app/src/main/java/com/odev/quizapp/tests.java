package com.odev.quizapp;

import java.util.ArrayList;

public class tests {

    private String testName;
    private int imageID;

    public tests(int imageID, String testName) {
        this.setImageID(imageID);
        this.setTestName(testName);
    }
    public tests() {
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public static ArrayList<tests> getData() {
       ArrayList<tests> testsList = new ArrayList<tests>();
        int testImages[] = {R.drawable.estesti, R.drawable.zekatesti, R.drawable.zengintesti,R.drawable.kisiliktesti,R.drawable.renktesti};
        String[] testNames = {"es","zeka","zengin","kisilik","renk"};

        for (int i = 0; i < testImages.length; i++) {
            tests temp = new tests();
            temp.setImageID(testImages[i]);
            temp.setTestName(testNames[i]);

            testsList.add(temp);
        }

        return testsList;
    }
}
