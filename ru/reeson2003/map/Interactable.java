package ru.reeson2003.map;
import java.util.List;
import ru.reeson2003.chars.Player;


public interface Interactable {
    String getInfo();
    List<Interactable> interact(Player player);
}
