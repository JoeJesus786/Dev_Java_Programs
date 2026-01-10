package InterviewTasks;

import java.util.ArrayList;
import java.util.List;

public class Sam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] arr= {0,1,0,4,5};
int index =0;
final List<String> list = new ArrayList<>();
list.add("A");
System.out.println(list);

for(int i=0;i<arr.length;i++)
{
	if(arr[i]!=0)
	{
		arr[index++]=arr[i];
	}
	
}

while(index<arr.length)
{
	arr[index++]=0;
}

for(int j=0;j<arr.length;j++)
{
System.out.print(arr[j]);	
}
	

	}
}

	