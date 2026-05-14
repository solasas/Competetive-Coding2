package classcodes;

public class HeapSort {
    static void Sort(int[] arr,int n){
        for(int i=(n/2)-1;i>=0;i--){
            heapify(arr,n,i);
        }
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,i,0);
        }
    }
    static void heapify(int arr[],int n,int par){
        int large=par;
        int l=2*par+1;
       int r=2*par+2;
        if(l<n && arr[l]>arr[large]) large=l;
        if(r<n && arr[r]>arr[large]) large=r;

        if(large!=par){
            int temp=arr[par];
            arr[par]=arr[large];
            arr[large]=temp;
            heapify(arr,n,large);
        }


    }
}
