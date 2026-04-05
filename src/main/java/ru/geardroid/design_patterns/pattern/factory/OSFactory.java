package ru.geardroid.design_patterns.pattern.factory;

import ru.geardroid.design_patterns.entity.os.LinuxOS;
import ru.geardroid.design_patterns.entity.os.MacOS;
import ru.geardroid.design_patterns.entity.os.OS;
import ru.geardroid.design_patterns.entity.os.WindowsOS;

public class OSFactory {

    public OS getCurrentOS(String input) {
        return switch (input) {
            case WindowsOS.NAME -> new WindowsOS();
            case LinuxOS.NAME -> new LinuxOS();
            case MacOS.NAME -> new MacOS();
            default -> throw new RuntimeException("No such OS type!");
        };
    }
}
