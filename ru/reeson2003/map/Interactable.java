package ru.reeson2003.map;
import java.util.List;

public interface Interactable {
    String getInfo();
    String getName();
    List<Interactable> interact(Interactable something);
}
