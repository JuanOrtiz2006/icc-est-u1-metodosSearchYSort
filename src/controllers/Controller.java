package controllers;
import models.Person;
import views.View;

public class Controller {
    private View view;
    private Person[] persons;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;

    public Controller() {
        this.view = new View();
        this.sortingMethods = new SortingMethods();
        this.searchMethods = new SearchMethods();
    }

    public void start() {
        int option;
        do {
            option = view.showMenu();
            switch (option) {
                case 1:
                    if (persons == null || persons.length == 0) {
                        System.out.println("No hay personas registradas.");
                    } else {
                        view.displayPersons(persons);
                    }
                    break;
                case 2:
                    inputPersons();
                    break;
                case 3:
                    addPersons();
                break;
                case 4:
                    if (persons == null || persons.length == 0) {
                        System.out.println("No hay personas para ordenar.");
                    } else {
                        sortPersons();
                    }
                    break;
                case 5:
                    if (persons == null || persons.length == 0) {
                        System.out.println("No hay personas para buscar.");
                    } else {
                        searchPersons();
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 5);
    }

    public void inputPersons(){
        int count = view.inputNumberOfPersons(); // Agregar método en View para solicitar el número de personas
        persons = new Person[count];
        for (int i = 0; i < count; i++) {
            persons[i] = view.inputPerson();
        }
    }

    public void addPersons() {
        Person newPerson = view.inputPerson();
        if (persons == null) {
            persons = new Person[]{newPerson};
        } else {
            Person[] updatedPersons = new Person[persons.length + 1];
            System.arraycopy(persons, 0, updatedPersons, 0, persons.length);
            updatedPersons[persons.length] = newPerson;
            persons = updatedPersons;
        }
    }

    public void sortPersons(){
        int option = view.selectSortingMethod();
        switch (option) {
            case 1:
                sortingMethods.sortByNameWithBuble(persons);
                break;
            case 2:
                sortingMethods.sortByNameWithSelectionDes(persons);;
                break;
            case 3:
                sortingMethods.sortByAgeWithInsertion(persons);;
                break;
            case 4:
                sortingMethods.sortByNameWithInsertion(persons);
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }

    public void searchPersons() {
        int option = view.selectSearchCriterion();
        switch (option) {
            case 1: // Buscar por nombre
                if (!searchMethods.isSortedByName(persons)) {
                    System.out.println("La lista no está ordenada por nombre. Ordene antes de buscar.");
                    return;
                }
                String name = view.inputName();
                Person personByName = searchMethods.binarySearchByName(persons, name);
                view.displaySearchResult(personByName);
                break;
            case 2: // Buscar por edad
                if (!searchMethods.isSortedByAge(persons)) {
                    System.out.println("La lista no está ordenada por edad. Ordene antes de buscar.");
                    return;
                }
                int age = view.inputAge();
                Person personByAge = searchMethods.binarySearchByAge(persons, age);
                view.displaySearchResult(personByAge);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}