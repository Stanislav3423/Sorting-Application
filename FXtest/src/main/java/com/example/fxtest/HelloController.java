package com.example.fxtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.*;
import java.util.*;

public class HelloController {
    @FXML
    private TextField NumTF = new TextField();
    @FXML
    private Button EnterNumBut = new Button();
    @FXML
    private TextField Arr1TF = new TextField();
    @FXML
    private TextField Arr2TF = new TextField();
    @FXML
    private Button SortBut = new Button();
    @FXML
    private TextField ResTF =new TextField();
    @FXML
    private Label TimeL = new Label();
    @FXML
    private Button ClearBut = new Button();
    private int numOfElements = 0;
    private int[] array1;
    private int[] array2;
    private int[] sortedArray;
    private int size;

    public void OnButtonEnterClick(ActionEvent event){
        numOfElements = Integer.parseInt(NumTF.getText());
        System.out.println(numOfElements);

        array1 = new int[numOfElements];
        array2 = new int[numOfElements];

        Random random = new Random();
        for (int i = 0; i < numOfElements; i++) {
            array1[i] = random.nextInt(100);
            array2[i] = random.nextInt(100);
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i<numOfElements; i++){
            sb1.append(array1[i]).append(" ");
            sb2.append(array2[i]).append(" ");
        }
        String arrayS1 = sb1.toString().trim();
        String arrayS2 = sb2.toString().trim();
        Arr1TF.setText(arrayS1);
        Arr2TF.setText(arrayS2);

        //Creating array for sorting
        Vector<Integer> vectArray = new Vector<Integer>();
        for (int i = 0; i<numOfElements; i++){
            if(array1[i]%2 == 0){
                vectArray.add(array1[i]);
            }
            if (array2[i]%2 != 0){
                vectArray.add(array2[i]);
            }
        }
        size = vectArray.size();
        sortedArray = new int[size];
        System.out.println("Array for sorting: ");
        for (int i = 0; i<size; i++){
            sortedArray[i] = vectArray.elementAt(i);
            System.out.print(sortedArray[i] + " ");
        }
        System.out.println();
    }
    public void OnButtonSortClick(){
        //Sorting
        sorting();
        //Display
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<size; i++){
            sb.append(sortedArray[i]).append(" ");
        }
        String arrayAsString = sb.toString().trim();
        ResTF.setText(arrayAsString);

        System.out.println("Sorted array: ");
        for (int i = 0; i<size; i++){
            System.out.print(sortedArray[i]+" ");
        }
    }
    public void sorting(){
        long startTime = System.nanoTime();
        for (int i = 0; i<size; i++){
            int temp = sortedArray[i], counter = i;
            for (int j=i; j<size; j++){
                if (sortedArray[j] < temp){
                    temp = sortedArray[j];
                    counter = j;
                }
            }
            sortedArray[counter] = sortedArray[i];
            sortedArray[i] = temp;
        }
        long estimatedTime = System.nanoTime() - startTime;
        TimeL.setText("Time: "+estimatedTime + " nsec");
    }

    public void OnButtonClearClick(ActionEvent event){
    }

}