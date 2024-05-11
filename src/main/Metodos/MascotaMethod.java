package main.Metodos;

import javax.swing.JOptionPane;

import main.Clases.Mascota;

public class MascotaMethod {
    
    static Mascota[] petArray = new Mascota[3];
    
    static int selectCamisa = 0;

    static int almacen = 0;

    public static void mascota(){
        do{
            //Try catch para evitar que el programa termine si hay un error
            try{ 
                Object[] options = {"Insertar", "Borrar", "Buscar", "Imprimir", "Editar", "Salir"};

                selectCamisa = JOptionPane.showOptionDialog(null,
                        "Seleccione una opción:",
                        "Zapato Tenis Menu",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]);

                switch(selectCamisa){
                    case 0:
                    inputMascota();
                    break;

                    case 1:
                    eraseMascota();
                    break;

                    case 2:
                    findMascota();
                    break;

                    case 3:
                    printMascota();
                    break;
                    
                    case 4:
                    editMascota();
                    break;

                    case 5:
                    return;
                        
                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Ups! Error!",
                "ERROR", JOptionPane.WARNING_MESSAGE);
            } 

        }while(selectCamisa != 5);
    }

    public static void inputMascota(){

        int count = Integer.valueOf(JOptionPane.showInputDialog(
            "Cuantas mascotas desea agregar?", 
            "01"));

        for(int i = 0; i < count; i++){

            if (almacen >= petArray.length) {
                JOptionPane.showMessageDialog(null, 
                "El almacen está lleno. No se pueden agregar más mascotas.", 
                "Almacen Lleno", JOptionPane.WARNING_MESSAGE);
                return;

            } else {
                String nombre = JOptionPane.showInputDialog(null,
                "Ingrese el nombre de la mascota " +  (almacen + 1) + ":",
                "MASCOTA");

                String especie = JOptionPane.showInputDialog(null,
                "Ingrese la especie de la mascota " +  (almacen + 1) + ":", 
                "ESPECIE");

                String raza = JOptionPane.showInputDialog(null,
                "Ingrese la raza de la mascota " +  (almacen + 1) + ":", 
                "RAZA");

                String color = JOptionPane.showInputDialog(null,
                "Ingrese la color de la mascota " +  (almacen + 1) + ":", 
                "COLOR");

                Mascota newPet = new Mascota(nombre, especie, raza, color);

                petArray[almacen] = newPet;

                JOptionPane.showMessageDialog(null, 
                "Mascota " + (almacen + 1) + " :\n" +
                newPet.toString(), 
                "Confirmacion de datos", JOptionPane.INFORMATION_MESSAGE);
            }

            almacen ++;
 
        }

    }

    public static void findMascota(){

        String nameFind = JOptionPane.showInputDialog(
                "Ingrese el nombre de la mascota");
        Mascota petFind = new Mascota(nameFind);

        for (Mascota pet : petArray) {
            if (pet != null && pet.equals(petFind)) {
                JOptionPane.showMessageDialog(null, 
                "Mascota encontrada: \n" + pet.toString(), 
                "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, 
        "La mascota con el nombre " + nameFind + " no ha sido encontrado.", 
        "Búsqueda Fallida", JOptionPane.WARNING_MESSAGE);

    } 

    public static void printMascota(){

        StringBuilder sb = new StringBuilder();

        sb.append("Lista de Mascotas:\n");

        for(Mascota pet : petArray){
            if(pet != null){
                sb.append(pet.toString()).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, 
        sb.toString(), "Mascotas", JOptionPane.INFORMATION_MESSAGE);

    }

    public static void editMascota() {
        String nameToRemove = JOptionPane.showInputDialog(
            "Ingrese el nombre de la mascota a cambiar"
        );

        Mascota petToErase = new Mascota(nameToRemove);
    
        for (int i = 0; i < petArray.length; i++) {

            if (petArray[i]!= null && petArray[i].equals(petToErase)) {

                int confirmacion = JOptionPane.showConfirmDialog(
                    null, 
                    "¿Estás seguro de que deseas editar la siguiente Mascota?\n" + 
                    petArray[i].toString(), 
                    "Confirmar Edición", 
                    JOptionPane.YES_NO_OPTION
                );

                if(confirmacion == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(
                        null, "Edicion cancelada", 
                        "Editar Cancelada", 
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    return;
                }

                if(confirmacion == JOptionPane.YES_OPTION){
                    String newNombre = JOptionPane.showInputDialog(
                        "Ingrese el nuevo nombre de la mascota", 
                        "NOMBRE");
                    String newEspecie = JOptionPane.showInputDialog(
                            "Ingrese la nueva especie de la mascota", 
                            "ESPECIE");
                    String newRaza = JOptionPane.showInputDialog(
                            "Ingrese la nueva raza de la mascota", 
                            "RAZA");
                    String newColor = JOptionPane.showInputDialog(
                            "Ingrese el nuevo color de la mascota", 
                            "COLOR");
        
                    Mascota newPet = new Mascota(newNombre, newEspecie, newRaza, newColor);
                    petArray[i] = newPet;
        
                    JOptionPane.showMessageDialog(null, 
                        "Mascota actualizada: \n" + newPet.toString(), 
                        "Actualizacion Exitosa", JOptionPane.INFORMATION_MESSAGE
                    );
                    printMascota();
                    return;
                }
            }
        }
    
        JOptionPane.showMessageDialog(null, 
            "La mascota con el nombre " + nameToRemove + " no ha sido encontrada.", 
            "Búsqueda Fallida", JOptionPane.WARNING_MESSAGE
        );
    }

    public static void eraseMascota(){

        String nameToRemove = JOptionPane.showInputDialog(
            "Ingrese el nombre de la mascota a eliminar");

        Mascota petToErase = new Mascota(nameToRemove);

        for (int i = 0; i < petArray.length; i++) {

            if (petArray[i]!= null && petArray[i].equals(petToErase)) {

                int confirmacion = JOptionPane.showConfirmDialog(
                    null, 
                    "¿Estás seguro de que deseas eliminar la siguinete Mascota?\n" + 
                    petArray[i].toString(), 
                    "Confirmar Eliminación", 
                    JOptionPane.YES_NO_OPTION
                );

                if(confirmacion == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(
                        null, "Eliminacion cancelada", 
                        "Eliminacion Cancelada", 
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    return;
                }

                JOptionPane.showMessageDialog(null, 
                    "Mascota eliminada: \n" + nameToRemove, 
                    "Eliminacion Exitosa", JOptionPane.INFORMATION_MESSAGE
                );

                for (int j = i; j < petArray.length - 1; j++) {
                    petArray[j] = petArray[j + 1];
                }

                petArray[petArray.length - 1] = null;

                almacen--;
                printMascota();
                return;
            }
        }
    
        JOptionPane.showMessageDialog(null, 
            "La mascota con el nombre " + nameToRemove + " no ha sido encontrada.", 
            "Búsqueda Fallida", JOptionPane.WARNING_MESSAGE
        );

    }

}
