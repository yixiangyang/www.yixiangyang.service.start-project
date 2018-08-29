package com.yixiangyang.java.sort;
/**
 * 归并排序
 * @author 15138
 *1、归并操作的工作原理如下：
 *2、第一步：申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 *3、第二步：设定两个指针，最初位置分别为两个已经排序序列的起始位置
 *4、第三步：比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 *5、重复步骤3直到某一指针超出序列尾
 *6、将另一序列剩下的所有元素直接复制到合并序列尾
 */
public class MergeSort {

//	public static void mergeSort(int[] a, int s, int len) {
//        int size = a.length;
//        int mid = size / (len << 1);
//        int c = size & ((len << 1) - 1);
//        //　-------归并到只剩一个有序集合的时候结束算法-------//
//        if (mid == 0)
//            return;
//        //　------进行一趟归并排序-------//
//        for (int i = 0; i < mid; ++i) {
//            s = i * 2 * len;
//            merge(a, s, s + len, (len << 1) + s - 1);
//        }
//        //　-------将剩下的数和倒数一个有序集合归并-------//
//        if (c != 0)
//            merge(a, size - c - 2 * len, size - c, size - 1);
//        //　-------递归执行下一趟归并排序------//
//        mergeSort(a, 0, 2 * len);
//    }
// 
//	private static void merge(int[] a, int s, int m, int t) {
//        int[] tmp = new int[t - s + 1];
//        int i = s, j = m, k = 0;
//        while (i < m && j <= t) {
//            if (a[i] <= a[j]) {
//                tmp[k] = a[i];
//                k++;
//                i++;
//            } else {
//                tmp[k] = a[j];
//                j++;
//                k++;
//            }
//        }
//        while (i < m) {
//            tmp[k] = a[i];
//            i++;
//            k++;
//        }
//        while (j <= t) {
//            tmp[k] = a[j];
//            j++;
//            k++;
//        }
//        System.arraycopy(tmp, 0, a, s, tmp.length);
//    }
	public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
	public static void main(String[] args) {
		int data[] = {4,8,12,3,1};
		for(int b:data) {
			System.out.println(b);
		}
		sort(data);
		System.out.println("-------------------------");
		for(int a:data) {
			System.out.println(a);
		}

	}

}
