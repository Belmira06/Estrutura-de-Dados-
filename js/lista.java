
import java.util.Scanner;

<!-- Inclua o Polyfill -->
<script src="https://www.javapoly.com/javapoly.js"></script>

public class ProgramaListaSimples {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Scanner scan= new Scanner(System.in);
		
		int opcao=0;
		ListaLigadaSimples<Integer> single= new ListaLigadaSimples<>();
		do {
			Menu();
			opcao=scan.nextInt();
			
				switch(opcao) 
				{
					case 1:
					{
						System.out.println("Digite um número:");
						Integer valor=scan.nextInt();
						simples.AdicionarPrimeiro(valor);
						
						break;
					}
					case 2:
					{
						System.out.println("Digite um número:");
						Integer valor=scan.nextInt();
						simples.AdicionarUltimo(valor);
						break;
					}
					case 3:
					{
					
						System.out.println(simples.toString());
						break;
					}
					
				default: 
					 System.out.println("Opção inválida! ");
				
				}
				
			
			
		   }while(opcao!= 4);
		
            scan.close();
	}
	
	public static void Menu()
	{
		System.out.println("-----------Menu-------------");
		System.out.println("1-Inserir o primeiro elemento na lista");
		System.out.println("2-Inserir o segundo elemento na lista");
		System.out.println("3-Mostrar o elemento na lista");
		System.out.println("4-Sair");
	}

}
<!-- Escreva seu código Java -->
<script type="lista/java">
  package com.demo;
  import com.javapoly.dom.Window;
  public class Greeter {
    public static void sayHello(String name) {
      Window.alert("Hello " + name + ", from Java!");
    }
  }
</script>

<!-- Chame seu código Java a partir do JavaScript -->
<script type="lista.java/javascript">
  com.demo.Greeter.sayHello("world");
</script>

