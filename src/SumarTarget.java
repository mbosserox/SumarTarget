package entrenamiento_entrevistas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SumarTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25
		int[] nums = {4,2,1};
		int target = 32;
		List<Integer> list = Arrays.stream(nums).boxed().filter(i -> i<=target).collect(Collectors.toList());
//		NodeTree root = new NodeTree(2);
		int  total =0;
		
		total =list.stream().map((e-> generarArbolPosibilidades(list, list.size()-1, new NodeTree(e,target)))).mapToInt(res ->res).sum();
//		generarArbolPosibilidades(nums,2,root);
		System.out.println(total);
	}

	public static int  generarArbolPosibilidades(List<Integer> list, int pos,NodeTree root) {
		int total =0;
		if(root!=null && pos>-1 && root.isTarget!=true) {
			
			NodeTree node = root.insertarHijo(root,list.get(pos));
			if(node!=null) {
				List<Integer> listSux= list.stream().filter(i -> i+node.sum<=root.target).collect(Collectors.toList());
				total =total+generarArbolPosibilidades(listSux,listSux.size()-1,node);	
			}
			total =total+generarArbolPosibilidades(list,pos-1,root);	
			
		}
		if(root.isTarget ) {
			return total+1;
		}
		return total; 
		
	}

}
