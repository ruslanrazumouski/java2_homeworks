package lesson_03;

import java.util.*;

public class PhoneBook {
    private Map<String, List> hashMap;

    public PhoneBook() {
        hashMap = new HashMap<String, List>();
    }

    public void addContact(Person person, String phones) {
        this.hashMap.put(person.getFio(), Arrays.asList( phones.split(", ") ));
    }

    public void addContact(Person person, String phones, String emails) {
        if ( !emails.isEmpty() ) {
            this.hashMap.put(person.getFio(), Arrays.asList( phones.split(", "), emails.split(", ") ));
        } else {
            addContact(person, phones);
        }
    }

    public void getAllPersonsInfo() {
        for( String fio : hashMap.keySet() ) {
            System.out.println( fio + " :" );
            for ( Object list : hashMap.get(fio) ) {
                if ( list.getClass().isArray() ) {
                    String[] subList = (String[]) list;
                    for (int i=0; i<subList.length; i++) {
                        System.out.println( "\t" + subList[i] );
                    }
                } else {
                    System.out.println( "\t" + list );
                }
            }
        }
    }

    public void getPersonInfo(String fio) {
        if ( hashMap.containsKey(fio) ) {
            System.out.println( fio + " :" );
            for ( Object list : hashMap.get(fio) ) {
                if ( list.getClass().isArray() ) {
                    String[] subList = (String[]) list;
                    for (int i = 0; i < subList.length; i++) {
                        System.out.println( "\t" + subList[i] );
                    }
                } else {
                    System.out.println( "\t" + list );
                }
            }
        } else {
            System.out.printf( "%s : \n\tфамилии нет в справочнике\n", fio );
        }
    }

    public void getPhones(String fio) {
        if ( hashMap.containsKey(fio) ) {
            System.out.println( fio + " :" );

            if ( hashMap.get(fio).get(0).getClass().isArray() ) {
                for (String phone : (String[]) hashMap.get(fio).get(0) ) {
                    System.out.println( "\t" + phone );
                }
            } else {
                for (String phone : (String[]) hashMap.get(fio).toArray() ) {
                    System.out.println( "\t" + phone );
                    }
            }
        } else {
            System.out.printf( "%s : \n\tфамилии нет в справочнике\n", fio );
        }
    }

    public void getEmails(String fio) {
        if ( hashMap.containsKey(fio) ) {
            System.out.println( fio + " :" );

            if ( hashMap.get(fio).get(0).getClass().isArray() ) {
                for ( String email : (String[]) hashMap.get(fio).get(1) ) {
                    System.out.println("\t" + email);
                }
            } else {
                System.out.println( "\tне содержит e-mail" );
            }
        } else {
            System.out.printf( "%s : \n\tфамилии нет в справочнике\n", fio );
        }
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "hashMap=" + hashMap +
                '}';
    }
}
