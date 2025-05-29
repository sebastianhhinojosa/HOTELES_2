// Clase Persona
class Persona {
    protected String nombre;
    protected String cedula;

    public Persona(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Cédula: " + cedula);
    }
}

// Clase Cliente (extiende Persona)
class Cliente extends Persona {
    private String email;

    public Cliente(String nombre, String cedula, String email) {
        super(nombre, cedula);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Email: " + email);
    }
}

// Clase Habitacion
class Habitacion {
    private int numero;
    private String tipo;
    private boolean disponible;

    public Habitacion(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponible = true;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public void reservar() {
        disponible = false;
    }

    public void liberar() {
        disponible = true;
    }
}

// Clase Reserva
class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;

    public Reserva(Cliente cliente, Habitacion habitacion) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        habitacion.reservar();
    }

    public void mostrarDetalle() {
        System.out.println("=== Detalle de Reserva ===");
        cliente.mostrarInfo();
        System.out.println("Habitación: " + habitacion.getNumero() + " (" + habitacion.getTipo() + ")");
    }
}

// Clase principal
public class HotelApp {
    public static void main(String[] args) {
        // Crear clientes
        Cliente cliente1 = new Cliente("Luis Pérez", "1102345678", "luis@example.com");

        // Crear habitaciones
        Habitacion h1 = new Habitacion(101, "Simple");
        Habitacion h2 = new Habitacion(102, "Doble");

        // Reservar una habitación
        if (h1.estaDisponible()) {
            Reserva reserva1 = new Reserva(cliente1, h1);
            reserva1.mostrarDetalle();
        } else {
            System.out.println("La habitación no está disponible.");
        }
    }
}
