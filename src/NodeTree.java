package entrenamiento_entrevistas;

public class NodeTree {
	
		 
	 int target;
	 int sum;
	 int valor;
	 NodeTree hijoMenor;
	 NodeTree hijoMayor;
	 String historia ="";
	 boolean isTarget= false;
	 public NodeTree() {}
	 public NodeTree(int num,int target) {
			sum = num;
			valor= num;
			historia=""+num;
			this.target=target;
			isTarget= num==target;
	 }
	 public NodeTree insertarHijo(NodeTree root, int num) {
		 if((sum+num)<=target) {
			 if(num<=valor) {
				 hijoMenor = new NodeTree();
				 hijoMenor.valor = num;
				 hijoMenor.sum =sum+num;
				 hijoMenor.historia= root.historia+"-"+num;
				 hijoMenor.target = root.target;
				 if((sum+num)==target) {
					 hijoMenor.isTarget= true;
					 System.out.println("target Encontrado"+hijoMenor.historia);
				 }
				 return hijoMenor;
			 }else {
				 hijoMayor = new NodeTree();
				 hijoMayor.valor = num;
				 hijoMayor.sum =sum+num; 
				 hijoMayor.historia= root.historia+"-"+num;
				 hijoMayor.target = root.target;
				 if((sum+num)==target) {
					 hijoMayor.isTarget= true;
					 System.out.println("target Encontrado "+hijoMayor.historia);
				 }
				 return hijoMayor;
			 }
			 
		 }
		 return null;
	 }
 
}
