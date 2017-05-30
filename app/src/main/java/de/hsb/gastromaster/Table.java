package de.hsb.gastromaster;

/**
 * Created by Gautama on 05/05/2017.
 */

public class Table {

    private String tableNumberText;
    private int tableNumber;
    private String numberOfDishText;
    private int numberOfDish;

    public Table( String tableNumberText, int tableNumber, String numberOfDishText ,int numberOfDish){

        this.tableNumberText = tableNumberText;
        this.tableNumber = tableNumber;
        this.numberOfDishText = numberOfDishText;
        this.numberOfDish = numberOfDish;

    }


    public String getNumberOfDishText()
    {

        return numberOfDishText;
    }
    public void setNumberOfDishText(String numberOfDishText)
    {
        this.numberOfDishText = numberOfDishText;
    }



    public int getNumberOfDish()
    {

        return numberOfDish;
    }
    public void setNumberOfDish(int numberOfDish)
    {

        this.numberOfDish = numberOfDish;
    }





    public String getTableNumberText()
    {

        return tableNumberText;
    }
    public void setTableNumberText(String tableNumberText)
    {
        this.tableNumberText = tableNumberText;
    }


    public int getTableNumber()
    {

        return tableNumber;
    }
    public void setTableNumber(int tableNumber)
    {
        this.tableNumber = tableNumber;
    }




}
