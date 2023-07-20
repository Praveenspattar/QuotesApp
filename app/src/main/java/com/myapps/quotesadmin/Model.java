package com.myapps.quotesadmin;



public class Model {

    private String quote;
    private String num;

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public Model(){}

    public Model(String quote, String num) {
        this.quote = quote;
        this.num = num;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
