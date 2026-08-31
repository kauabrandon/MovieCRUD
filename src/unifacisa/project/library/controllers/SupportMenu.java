package unifacisa.project.library.controllers;

import unifacisa.project.library.enums.SupportStatus;
import unifacisa.project.library.model.Support;
import unifacisa.project.library.services.SupportService;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class SupportMenu {
    private static final String[] OPTIONS = {"List open tickets", "Start handling a ticket", "Resolve a ticket", "Close a ticket", "Back"};

    private final SupportService supportService;

    public SupportMenu(SupportService supportService) {
        this.supportService = supportService;
    }

    public void show() {
        boolean inMenu = true;
        while (inMenu) {
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Support tickets", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, OPTIONS, OPTIONS[0]);
            switch (choice) {
                case 0 -> listOpenTickets();
                case 1 -> startHandling();
                case 2 -> resolveTicket();
                case 3 -> closeTicket();
                default -> inMenu = false;
            }
        }
    }

    private void listOpenTickets() {
        List<Support> supports = supportService.findByStatus(SupportStatus.OPEN);
        if (supports.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No open tickets");
            return;
        }
        String message = supports.stream().map(support -> support + "\n -> " + support.getHandlingInstructions()).collect(Collectors.joining("\n\n"));

        JOptionPane.showMessageDialog(null, message, "Open Tickets", JOptionPane.INFORMATION_MESSAGE);
    }

    private void startHandling() {
        Long id = readTicketId();
        if (id == null) return;
        supportService.startHandling(id);
        JOptionPane.showMessageDialog(null, "Ticket is now in progress");
    }

    private void resolveTicket() {
        Long id = readTicketId();
        if (id == null) return;
        supportService.resolve(id);
        JOptionPane.showMessageDialog(null, "Ticket resolved");
    }

    public void closeTicket() {
        Long id = readTicketId();
        if (id == null) return;
        supportService.close(id);
        JOptionPane.showMessageDialog(null, "Ticket closed");
    }

    private Long readTicketId() {
        String input = JOptionPane.showInputDialog(null, "Ticket id:");
        if (input == null) return null;

        try {
            return Long.parseLong(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid id!", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
