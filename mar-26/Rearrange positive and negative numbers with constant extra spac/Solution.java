
class Solution {

    public void Rearrange(int a[], int n) {
        
         mergeSort(a,0,n-1);
    }
    public void mergeSort(int a[],int l,int r){
        if(l>=r)return;
        int mid=l+(r-l)/2;
        
        mergeSort(a,l,mid);
        mergeSort(a,mid+1,r);
        merge(a,l,mid,r);
    }
    public void merge(int[]a,int l,int mid,int r){
        int temp[]=new int[r-l+1];
        int k=0;
        
        for(int i=l;i<=mid;i++){
            if(a[i]<0){
                temp[k++]=a[i];
            }
        }
        for(int i=mid+1;i<=r;i++){
            if(a[i]<0){
                temp[k++]=a[i];
            }
        }
        for(int i=l;i<=mid;i++){
            if(a[i]>=0){
                temp[k++]=a[i];
            }
        }
        for(int i=mid+1;i<=r;i++){
            if(a[i]>=0){
                temp[k++]=a[i];
            }
        }
        for(int i=0;i<temp.length;i++){
            a[i+l]=temp[i];
        }
        
    }
}