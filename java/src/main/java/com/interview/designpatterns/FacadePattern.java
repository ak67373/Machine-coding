package com.interview.designpatterns;

/**
 * Facade Pattern
 * Provides a simplified interface to a complex subsystem
 */
public class FacadePattern {
    
    public static void main(String[] args) {
        System.out.println("=== FACADE PATTERN ===\n");
        
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
        System.out.println();
        computer.shutdownComputer();
    }
}

class CPU {
    public void freeze() {
        System.out.println("CPU freeze");
    }

    public void jump(long position) {
        System.out.println("CPU jump to position: " + position);
    }

    public void execute() {
        System.out.println("CPU execute");
    }
}

class Memory {
    public void load(long position, byte[] data) {
        System.out.println("Memory load data at position: " + position);
    }
}

class HardDrive {
    public byte[] read(long lba, int size) {
        System.out.println("HardDrive read " + size + " bytes from LBA: " + lba);
        return new byte[size];
    }
}

class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        System.out.println("Starting computer...");
        cpu.freeze();
        memory.load(0, hardDrive.read(0, 1024));
        cpu.jump(0);
        cpu.execute();
        System.out.println("Computer started!");
    }

    public void shutdownComputer() {
        System.out.println("Shutting down computer...");
        System.out.println("Computer shutdown complete!");
    }
}

