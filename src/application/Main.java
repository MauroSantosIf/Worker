package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entitiesEnum.WorkerLevel;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Entre com o nome do departamento: ");
        String nomeDepartamento = sc.nextLine();

        System.out.println("Insira os dados do trabalhador: ");
        System.out.print("Nome: ");
        String nomeTrabalhador = sc.nextLine();

        System.out.print("Nível: ");
        String nivelTrabalhador = sc.nextLine();

        System.out.print("Salário Base: ");
        double salarioBase = sc.nextDouble();

        Worker trabalhador = new Worker(nomeTrabalhador, WorkerLevel.valueOf(nivelTrabalhador), salarioBase, new Department(nomeDepartamento));

        System.out.print("Quantos contratos esse trabalhador tem? ");
        int QuantidadeContratos = sc.nextInt();

        for(int i = 1 ; i<=QuantidadeContratos; i++){
            System.out.printf("Insira os dados do contrato nº %d:%n",i);

            System.out.print("Data (DD/MM/YYYY): ");
            Date dataContrato = sdf.parse(sc.next());

            System.out.print("Valor por hora: ");
            double valorPorHora = sc.nextDouble();

            System.out.print("Duração do contrato: ");
            int horas = sc.nextInt();

            HourContract contrato = new HourContract(dataContrato, valorPorHora,horas);
            trabalhador.addContract(contrato);
        }

        System.out.println();

        System.out.print("Insira o mês e o ano para calcular a renda (MM/AAAA): ");
        String monthAno = sc.next();

        sc.close();

        int mes = Integer.parseInt(monthAno.substring(0,2)); 

        int ano = Integer.parseInt(monthAno.substring(3)); 

        System.out.println("Nome: "+ trabalhador.getName());
        System.out.println("Departamento: "+ trabalhador.getDepartmente().getName());
        System.out.println("Renda de "+monthAno+": "+ String.format("%.2f", trabalhador.income(ano, mes)) );
    }

}
