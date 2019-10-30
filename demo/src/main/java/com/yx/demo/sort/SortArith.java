package com.yx.sort;

import java.util.Arrays;

public class SortArith {

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static int[] bubble_sort(int[] arr){
        if(arr==null || arr.length==0){
            return arr;
        }
        for(int i=arr.length-1; i>0; i-- ){
            boolean flag = false;
            for(int j=0; j<i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
        return arr;
    }

    private static int[] select_sort(int[] arr){
        if(arr==null || arr.length==0){
            return arr;
        }
        for(int i=0; i<arr.length-1; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            swap(arr,i,min);
        }
        return arr;
    }

    //将数组分为若干子数组，然后两两数组合并，最终排成一个有序数组。
    private static int[] merge_sort(int []arr){
        if(arr==null||arr.length<2){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);

        return  merge(merge_sort(left),merge_sort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length+right.length];
        for(int i=0,j=0,index=0;index<result.length;index++){
          if(i>=left.length){
              result[index] = right[j++];
          }else if(j>=right.length){
              result[index] = left[i++];
          }else if(left[i]>right[j]){
              result[index] = right[j++];
          }else{
              result[index] = left[i++];
          }
        }
        return result;
    }

    private static int[] quick_sort(int[] arr,int start,int end){
        if(arr==null||arr.length==0||start<0||end>=arr.length||start>end){
            return arr;
        }
        //一次快排后小于基准值的最大索引
        int smallIndex = partition(arr,start,end);
        if(smallIndex>start){
            quick_sort(arr,start,smallIndex-1);
        }
        if(smallIndex<end){
            quick_sort(arr,smallIndex+1,end);
        }
        return arr;
    }

    private static int partition(int arr[], int start,int end){
        //随机寻找基准值所在位
        int pivot = (start+end)/2;
        //小于基准值的元素应在的索引位置
        int smallIndex = start-1;
        //将基准值放在最右侧
        swap(arr, pivot, end);
        for(int i=start;i<=end;i++){
            if(arr[i]<=arr[end]){
                smallIndex++;
                if(i>smallIndex){
                    swap(arr,i,smallIndex);
                }
            }
        }
        return smallIndex;

    }


    public static void main(String[] args) {
        int arr[] = {2,5,1,3,4};
//        System.out.println(Arrays.toString(bubble_sort(arr)));
//        System.out.println(Arrays.toString(select_sort(arr)));
//        System.out.println(Arrays.toString(merge_sort(arr)));
        System.out.println(Arrays.toString(quick_sort(arr,0,arr.length-1)));
    }
}
