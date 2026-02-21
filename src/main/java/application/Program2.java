package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        SellerDao sellerDao = DaoFactory.createSellerDao();
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        int option = -1;

        do {
            try {
                System.out.println("\n=== MENU DE GERENCIAMENTO (SQL) ===");
                System.out.println("1 - Seller: FindById");
                System.out.println("2 - Seller: FindByDepartment");
                System.out.println("3 - Seller: FindAll");
                System.out.println("4 - Seller: Insert");
                System.out.println("5 - Seller: Update");
                System.out.println("6 - Seller: Delete");
                System.out.println("---------------------------");
                System.out.println("7 - Department: FindById");
                System.out.println("8 - Department: FindAll");
                System.out.println("9 - Department: Insert");
                System.out.println("10 - Department: Update");
                System.out.println("11 - Department: Delete (with Migration)");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");

                option = Integer.parseInt(sc.nextLine());

                switch (option) {
                    case 1:
                        System.out.print("Digite o ID do Seller: ");
                        int idFind = Integer.parseInt(sc.nextLine());
                        Seller seller = sellerDao.findById(idFind);
                        System.out.println(seller);
                        break;

                    case 2:
                        System.out.print("Digite o ID do Department: ");
                        int depIdFind = Integer.parseInt(sc.nextLine());
                        List<Seller> listDep = sellerDao.findByDepartment(depIdFind);
                        listDep.forEach(System.out::println);
                        break;

                    case 3:
                        List<Seller> listAll = sellerDao.findAll();
                        listAll.forEach(System.out::println);
                        break;

                    case 4:
                        System.out.println("Inserir novo Seller:");
                        System.out.print("Nome: ");
                        String name = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Salário Base: ");
                        double salary = Double.parseDouble(sc.nextLine());
                        System.out.print("ID do Departamento: ");
                        int depIdIns = Integer.parseInt(sc.nextLine());
                        System.out.print("Data de nascimento: ");
                        Date date = sdf.parse(sc.nextLine());

                        Department dep = new Department(depIdIns, null);
                        Seller newSeller = new Seller(salary, date, dep,name, null, email);
                        sellerDao.insert(newSeller);
                        System.out.println("Inserido! Novo ID: " + newSeller.getId());
                        break;

                    case 5:
                        System.out.print("ID do Seller para atualizar: ");
                        int upId = Integer.parseInt(sc.nextLine());
                        Seller sellerUp = sellerDao.findById(upId);
                        if (sellerUp != null) {
                            System.out.print("Novo Nome: ");
                            sellerUp.setName(sc.nextLine());
                            System.out.print("Novo Salario: ");
                            sellerUp.setBaseSalary(Double.parseDouble(sc.nextLine()));
                            System.out.print("Novo email: ");
                            sellerUp.setEmail(sc.nextLine());
                            System.out.print("Novo Departamento (Id - Nome): ");
                            sellerUp.setDepartment(new Department(Integer.parseInt(sc.nextLine()), sc.nextLine()));
                            System.out.print("Nova data de nascimento: ");
                            Date data = sdf.parse(sc.nextLine());
                            sellerUp.setBirthDate(data);
                            sellerDao.update(sellerUp);
                            System.out.println("Atualização concluída!");
                        } else {
                            System.out.println("Seller não encontrado.");
                        }
                        break;

                    case 6:
                        System.out.print("ID para deletar: ");
                        int delId = Integer.parseInt(sc.nextLine());
                        sellerDao.deleteById(delId);
                        System.out.println("Deletado com sucesso!");
                        break;

                    case 7:
                        System.out.print("ID do Department: ");
                        int dId = Integer.parseInt(sc.nextLine());
                        Department d = departmentDao.findById(dId);
                        System.out.println(d);
                        break;

                    case 8:
                        List<Department> depList = departmentDao.findAll();
                        depList.forEach(System.out::println);
                        break;

                    case 9:
                        System.out.print("Nome do novo Departamento: ");
                        Department newDep = new Department(null, sc.nextLine());
                        departmentDao.insert(newDep);
                        System.out.println("Inserido! Novo ID: " + newDep.getId());
                        break;

                    case 10:
                        System.out.print("ID do Department para atualizar: ");
                        int depUpId = Integer.parseInt(sc.nextLine());
                        Department depUpdate = departmentDao.findById(depUpId);
                        if (depUpdate != null) {
                            System.out.print("Novo Nome: ");
                            depUpdate.setName(sc.nextLine());
                            departmentDao.update(depUpdate);
                            System.out.println("Atualizado!");
                        } else {
                            System.out.println("Departamento não encontrado.");
                        }
                        break;

                    case 11:
                        System.out.print("ID do Departamento a ser DELETADO: ");
                        Department del = departmentDao.findById(Integer.parseInt(sc.nextLine()));
                        System.out.print("ID do Departamento para onde os Sellers migrarão: ");
                        Department mig = departmentDao.findById(Integer.parseInt(sc.nextLine()));

                        if (del != null && mig != null) {
                            departmentDao.deleteById(del, mig);
                            System.out.println("Migração e exclusão concluídas!");
                        } else {
                            System.out.println("Um ou ambos os departamentos não foram encontrados.");
                        }
                        break;

                    case 0:
                        System.out.println("Encerrando programa...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, insira um valor numérico válido.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        } while (option != 0);

        sc.close();
    }
}

