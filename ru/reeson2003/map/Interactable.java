package ru.reeson2003.map;
import java.util.List;

public interface Interactable {
    String getInfo();
    List<Interactable> interact(Interactable something);
}
