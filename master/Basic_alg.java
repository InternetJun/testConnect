//要实现的是插入排序的内容。
public void sortInsert(int[] nums){
	int n = nums.length;
	for(int i = 0; i < n; i++) {
		int insertVal = nums[i];
		int insertIndex = i - 1;
		while(insertVal < nums[i]) {//0元素没有管理的。
			nums[insertIndex+1] = nums[insertIndex];
			insertIndex--;
		}
		nums[insertIndex+1] = insertVal;
	}
}

//增量排序
//堆排序
public void heapSort(int[] nums) {
	int n = nums.length;
	//从飞叶子节点开始的。
	for(int i = n/2-1; i >= 0; i--) {
		//adjustHeap;
	}
}

//大堆的排序；
public void adjustHeap(int[] nums, int n, int i) {
	for(int k = 2*i+1; k < n; k = 2*k +1){
		if(k+1< n && nums[k] < nums[k+1]) {//找大的。
			k++;
		} 
		if(nums[k] > temp){
			nums[i] = nums[k];
			i = k;
		}else{
			//比较元素的大小；
			break;
		}
		arr[i] = temp;
	}
}

//小堆的
public void adjustHeapDes(int[] nums, int n, int i) {
	for(int k = 2*i+1; k < n; k = 2*k +1){
		if(k+1< n && nums[k+1] < nums[k]) {//找大的。
			k++;
		} 
		if(nums[k] < temp){
			nums[i] = nums[k];
			i = k;
		}else{
			//比较元素的大小；
			break;
		}
		arr[i] = temp;
	}
}