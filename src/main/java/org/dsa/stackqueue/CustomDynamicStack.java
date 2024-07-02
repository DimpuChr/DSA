package org.dsa.stackqueue;

import java.util.Arrays;

public class CustomDynamicStack<T> extends CustomStackGeneric{

    @Override
    public boolean push(Object value) {

        if(super.isFull()){

            T[] temp = (T[]) new Object[data.length * 2];

           /* for (int i = 0; i < data.length; i++) {
                temp[i] = (T) data[i];
            }*/
            System.arraycopy(data,0,temp,0,data.length);
            data = temp;
            return true;
        }
        super.push(value);
        return true;
    }
}
