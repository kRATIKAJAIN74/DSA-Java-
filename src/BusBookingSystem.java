import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

// ---------- MODEL CLASSES ----------

class Bus implements Serializable {
    private String busId;
    private String from;
    private String to;
    private String time;
    private double fare;
    private int totalSeats;
    private List<Integer> bookedSeats = new ArrayList<>();

    public Bus(String busId, String from, String to, String time, double fare, int totalSeats) {
        this.busId = busId;
        this.from = from;
        this.to = to;
        this.time = time;
        this.fare = fare;
        this.totalSeats = totalSeats;
    }

    public String getBusId() { return busId; }
    public String getFrom() { return from; }
    public String getTo() { return to; }
    public String getTime() { return time; }
    public double getFare() { return fare; }
    public int getTotalSeats() { return totalSeats; }

    public List<Integer> getAvailableSeats() {
        List<Integer> available = new ArrayList<>();
        for (int i = 1; i <= totalSeats; i++) {
            if (!bookedSeats.contains(i)) available.add(i);
        }
        return available;
    }

    public boolean bookSeat(int seat) {
        if (!bookedSeats.contains(seat) && seat <= totalSeats && seat > 0) {
            bookedSeats.add(seat);
            return true;
        }
        return false;
    }

    public boolean cancelSeat(int seat) {
        return bookedSeats.remove(Integer.valueOf(seat));
    }

    @Override
    public String toString() {
        return busId + " | " + from + " → " + to + " | " + time + " | ₹" + fare;
    }
}

class Booking implements Serializable {
    private String bookingId;
    private String passenger;
    private String busId;
    private int seatNo;
    private Date date;

    public Booking(String passenger, String busId, int seatNo) {
        this.bookingId = UUID.randomUUID().toString().substring(0, 8);
        this.passenger = passenger;
        this.busId = busId;
        this.seatNo = seatNo;
        this.date = new Date();
    }

    public String getBookingId() { return bookingId; }
    public String getPassenger() { return passenger; }
    public String getBusId() { return busId; }
    public int getSeatNo() { return seatNo; }
    public String getDate() {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm").format(date);
    }
}

// ---------- SERVICE CLASS ----------

class BusBookingService {
    private List<Bus> buses = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private final String DATA_FILE = "busdata.dat";

    public BusBookingService() {
        load();
        if (buses.isEmpty()) {
            buses.add(new Bus("BUS101", "Delhi", "Jaipur", "08:00 AM", 500, 5));
            buses.add(new Bus("BUS202", "Delhi", "Agra", "09:30 AM", 400, 4));
            buses.add(new Bus("BUS303", "Delhi", "Chandigarh", "07:00 AM", 600, 6));
            save();
        }
    }

    public List<Bus> getBuses() { return buses; }
    public List<Booking> getBookings() { return bookings; }

    public Bus getBusById(String id) {
        return buses.stream().filter(b -> b.getBusId().equals(id)).findFirst().orElse(null);
    }

    public boolean makeBooking(String passenger, String busId, int seatNo) {
        Bus bus = getBusById(busId);
        if (bus != null && bus.bookSeat(seatNo)) {
            bookings.add(new Booking(passenger, busId, seatNo));
            save();
            return true;
        }
        return false;
    }

    public boolean cancelBooking(String bookingId) {
        Booking bk = bookings.stream().filter(b -> b.getBookingId().equals(bookingId)).findFirst().orElse(null);
        if (bk != null) {
            Bus bus = getBusById(bk.getBusId());
            if (bus != null) bus.cancelSeat(bk.getSeatNo());
            bookings.remove(bk);
            save();
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            Object[] data = (Object[]) ois.readObject();
            buses = (List<Bus>) data[0];
            bookings = (List<Booking>) data[1];
        } catch (Exception ignored) {}
    }

    private void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(new Object[]{buses, bookings});
        } catch (Exception e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }
}

// ---------- GUI CLASS ----------

public class BusBookingSystem extends JFrame {
    private final BusBookingService service = new BusBookingService();
    private JTable busTable, bookingTable;
    private JTextField txtPassenger, txtSeat, txtBookingId;

    public BusBookingSystem() {
        setTitle("🚌 Bus Booking System");
        setSize(850, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Available Buses", createBusPanel());
        tabs.add("Bookings", createBookingPanel());
        add(tabs);

        setVisible(true);
    }

    private JPanel createBusPanel() {
        JPanel p = new JPanel(new BorderLayout());
        String[] cols = {"Bus ID", "From", "To", "Time", "Fare", "Seats"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        busTable = new JTable(model);
        refreshBusTable();

        JPanel form = new JPanel(new FlowLayout());
        txtPassenger = new JTextField(10);
        txtSeat = new JTextField(3);
        JButton btnBook = new JButton("Book Seat");

        btnBook.addActionListener(e -> {
            int row = busTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a bus first!");
                return;
            }
            String busId = (String) busTable.getValueAt(row, 0);
            String passenger = txtPassenger.getText().trim();
            int seat;
            try {
                seat = Integer.parseInt(txtSeat.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter a valid seat number.");
                return;
            }
            if (service.makeBooking(passenger, busId, seat)) {
                JOptionPane.showMessageDialog(this, "Seat booked successfully!");
                refreshBusTable();
                refreshBookingTable();
            } else {
                JOptionPane.showMessageDialog(this, "Seat not available or invalid!");
            }
        });

        form.add(new JLabel("Passenger:"));
        form.add(txtPassenger);
        form.add(new JLabel("Seat No:"));
        form.add(txtSeat);
        form.add(btnBook);

        p.add(new JScrollPane(busTable), BorderLayout.CENTER);
        p.add(form, BorderLayout.SOUTH);
        return p;
    }

    private JPanel createBookingPanel() {
        JPanel p = new JPanel(new BorderLayout());
        String[] cols = {"Booking ID", "Passenger", "Bus ID", "Seat", "Date"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        bookingTable = new JTable(model);
        refreshBookingTable();

        JPanel cancelPanel = new JPanel(new FlowLayout());
        txtBookingId = new JTextField(10);
        JButton btnCancel = new JButton("Cancel Booking");

        btnCancel.addActionListener(e -> {
            String id = txtBookingId.getText().trim();
            if (service.cancelBooking(id)) {
                JOptionPane.showMessageDialog(this, "Booking cancelled!");
                refreshBookingTable();
                refreshBusTable();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Booking ID!");
            }
        });

        cancelPanel.add(new JLabel("Booking ID:"));
        cancelPanel.add(txtBookingId);
        cancelPanel.add(btnCancel);

        p.add(new JScrollPane(bookingTable), BorderLayout.CENTER);
        p.add(cancelPanel, BorderLayout.SOUTH);
        return p;
    }

    private void refreshBusTable() {
        DefaultTableModel model = (DefaultTableModel) busTable.getModel();
        model.setRowCount(0);
        service.getBuses().forEach(bus -> {
            model.addRow(new Object[]{
                    bus.getBusId(),
                    bus.getFrom(),
                    bus.getTo(),
                    bus.getTime(),
                    bus.getFare(),
                    bus.getAvailableSeats()
            });
        });
    }

    private void refreshBookingTable() {
        DefaultTableModel model = (DefaultTableModel) bookingTable.getModel();
        model.setRowCount(0);
        service.getBookings().forEach(bk -> {
            model.addRow(new Object[]{
                    bk.getBookingId(),
                    bk.getPassenger(),
                    bk.getBusId(),
                    bk.getSeatNo(),
                    bk.getDate()
            });
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BusBookingSystem::new);
    }
}