package Ajedrez_Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Pruebas {
    private static JButton[][] buttons;
    private static Timer animacionTimer;
    private static final int TAMAÑO_ORIGINAL = 50; // Tamaño original de la pieza
    private static final int TAMAÑO_MAXIMO = 60;   // Tamaño máximo durante la animación
    private static boolean aumentando = true;      // Controla la dirección de la animación


    private static Color[][] originalColors; // Arreglo para almacenar los colores originales

    private static JButton selectedButton;
    private static boolean isWhiteTurn = true;

    //private static HashMap<JButton, Boolean> colorDePiezas = new HashMap<>();




    public static JButton[][] inicializarTablero(JPanel chess) {
        originalColors = new Color[10][10]; // Asegúrate de que este tamaño coincida con el de tu arreglo de botones

        // Fichas negras
        ImageIcon torreNegraIcon = new ImageIcon("/Users/j_alcon/Library/Mobile Documents/com~apple~CloudDocs/Escuela/Segundo semestre/05 Programación orientada a entornos visuales/1er parcial/JAVA Ejercicios/Ajedrez_proyect/src/main/java/Imagenes/TorreNegra.png");
        ImageIcon caballoNegroIcon = new ImageIcon("/Users/j_alcon/Library/Mobile Documents/com~apple~CloudDocs/Escuela/Segundo semestre/05 Programación orientada a entornos visuales/1er parcial/JAVA Ejercicios/Ajedrez_proyect/src/main/java/Imagenes/CaballoNegro.png");
        ImageIcon alfilNegroIcon = new ImageIcon("/Users/j_alcon/Library/Mobile Documents/com~apple~CloudDocs/Escuela/Segundo semestre/05 Programación orientada a entornos visuales/1er parcial/JAVA Ejercicios/Ajedrez_proyect/src/main/java/Imagenes/AlfilNegro.png");
        ImageIcon reinaNegraIcon = new ImageIcon("/Users/j_alcon/Library/Mobile Documents/com~apple~CloudDocs/Escuela/Segundo semestre/05 Programación orientada a entornos visuales/1er parcial/JAVA Ejercicios/Ajedrez_proyect/src/main/java/Imagenes/ReinaNegra.png");
        ImageIcon reyNegroIcon = new ImageIcon("/Users/j_alcon/Library/Mobile Documents/com~apple~CloudDocs/Escuela/Segundo semestre/05 Programación orientada a entornos visuales/1er parcial/JAVA Ejercicios/Ajedrez_proyect/src/main/java/Imagenes/ReyNegro.png");
        ImageIcon peonNegroIcon = new ImageIcon("/Users/j_alcon/Library/Mobile Documents/com~apple~CloudDocs/Escuela/Segundo semestre/05 Programación orientada a entornos visuales/1er parcial/JAVA Ejercicios/Ajedrez_proyect/src/main/java/Imagenes/PeonNegro.png");

        // Fichas blancas
        ImageIcon torreBlancaIcon = new ImageIcon("/Users/j_alcon/Library/Mobile Documents/com~apple~CloudDocs/Escuela/Segundo semestre/05 Programación orientada a entornos visuales/1er parcial/JAVA Ejercicios/Ajedrez_proyect/src/main/java/Imagenes/TorreBlanca.png");
        ImageIcon caballoBlancoIcon = new ImageIcon("/Users/j_alcon/Library/Mobile Documents/com~apple~CloudDocs/Escuela/Segundo semestre/05 Programación orientada a entornos visuales/1er parcial/JAVA Ejercicios/Ajedrez_proyect/src/main/java/Imagenes/CaballoBlanco.png");
        ImageIcon alfilBlancoIcon = new ImageIcon("/Users/j_alcon/Library/Mobile Documents/com~apple~CloudDocs/Escuela/Segundo semestre/05 Programación orientada a entornos visuales/1er parcial/JAVA Ejercicios/Ajedrez_proyect/src/main/java/Imagenes/AlfilBlanco.png");
        ImageIcon reinaBlancaIcon = new ImageIcon("/Users/j_alcon/Library/Mobile Documents/com~apple~CloudDocs/Escuela/Segundo semestre/05 Programación orientada a entornos visuales/1er parcial/JAVA Ejercicios/Ajedrez_proyect/src/main/java/Imagenes/ReinaBlanca.png");
        ImageIcon reyBlancoIcon = new ImageIcon("/Users/j_alcon/Library/Mobile Documents/com~apple~CloudDocs/Escuela/Segundo semestre/05 Programación orientada a entornos visuales/1er parcial/JAVA Ejercicios/Ajedrez_proyect/src/main/java/Imagenes/ReyBlanco.png");
        ImageIcon peonBlancoIcon = new ImageIcon("/Users/j_alcon/Library/Mobile Documents/com~apple~CloudDocs/Escuela/Segundo semestre/05 Programación orientada a entornos visuales/1er parcial/JAVA Ejercicios/Ajedrez_proyect/src/main/java/Imagenes/PeonBlanco.png");
        buttons = new JButton[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Asumiendo que las casillas alternan colores
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    originalColors[i][j] = new Color(255, 247, 217); // Color para casillas claras
                } else {
                    originalColors[i][j] = new Color(65, 56, 56); // Color para casillas oscuras
                }
            }
        }

        for (int i = 0; i < 100; i++) {

            if (i == 0 || i == 9 || i == 90 || i == 99) {
                chess.add(new JLabel(""));
            } else if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 91 || i == 92 || i == 93 || i == 94 || i == 95 || i == 96 || i == 97 || i == 98) {
                // Label letras
                JLabel letras = new JLabel();
                letras.setHorizontalAlignment(SwingConstants.CENTER);
                switch (i) {
                    case 1, 91:
                        letras.setText("A");
                        break;
                    case 2, 92:
                        letras.setText("B");
                        break;
                    case 3, 93:
                        letras.setText("C");
                        break;
                    case 4, 94:
                        letras.setText("D");
                        break;
                    case 5, 95:
                        letras.setText("E");
                        break;
                    case 6, 96:
                        letras.setText("F");
                        break;
                    case 7, 97:
                        letras.setText("G");
                        break;
                    case 8, 98:
                        letras.setText("H");
                        break;
                }
                chess.add(letras);
            } else if (i == 10 || i == 19 || i == 20 || i == 29 || i == 30 || i == 39 || i == 40 || i == 49 || i == 50 || i == 59 || i == 60 || i == 69 || i == 70 || i == 79 || i == 80 || i == 89) {
                // Label numeros
                JLabel numeros = new JLabel();
                numeros.setHorizontalAlignment(SwingConstants.CENTER);
                switch (i) {
                    case 10, 19:
                        numeros.setText("8");
                        break;
                    case 20, 29:
                        numeros.setText("7");
                        break;
                    case 30, 39:
                        numeros.setText("6");
                        break;
                    case 40, 49:
                        numeros.setText("5");
                        break;
                    case 50, 59:
                        numeros.setText("4");
                        break;
                    case 60, 69:
                        numeros.setText("3");
                        break;
                    case 70, 79:
                        numeros.setText("2");
                        break;
                    case 80, 89:
                        numeros.setText("1");
                        break;
                }
                chess.add(numeros);
            }else{
                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());
                JButton button = new JButton();
                panel.add(button, BorderLayout.CENTER);
                button.setOpaque(true);
                button.setBorderPainted(false);
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.addActionListener(new MyActionListener());
                if (((i % 2 == 1) && (i <= 19)) || ((i % 2 == 0) && (i >= 21) && (i <= 29))
                        || ((i % 2 == 1) && (i >= 31) && (i <= 39)) || ((i % 2 == 0) && (i >= 41) && (i <= 49))
                        || ((i % 2 == 1) && (i >= 51) && (i <= 59)) || ((i % 2 == 0) && (i >= 61) && (i <= 69))
                        || ((i % 2 == 1) && (i >= 71) && (i <= 79)) || ((i % 2 == 0) && (i >= 81))) {
                    panel.setBackground(new Color(255, 247, 217, 255));
                    switch (i) {
                        case 11:
                            button.setIcon(new ImageIcon(torreNegraIcon.getImage()));
                            //colorDePiezas.put(button, false);
                            break;
                        case 13:
                            button.setIcon(new ImageIcon(alfilNegroIcon.getImage()));
                            //colorDePiezas.put(button, false);
                            break;
                        case 15:
                            button.setIcon(new ImageIcon(reyNegroIcon.getImage()));
                            //colorDePiezas.put(button, false);
                            break;
                        case 17:
                            button.setIcon(new ImageIcon(caballoNegroIcon.getImage()));
                            //colorDePiezas.put(button, false);
                            break;
                        case 82:
                            button.setIcon(new ImageIcon(caballoBlancoIcon.getImage()));
                            //colorDePiezas.put(button, true);
                            break;
                        case 84:
                            button.setIcon(new ImageIcon(reinaBlancaIcon.getImage()));
                            //colorDePiezas.put(button, true);
                            break;
                        case 86:
                            button.setIcon(new ImageIcon(alfilBlancoIcon.getImage()));
                            //colorDePiezas.put(button, true);
                            break;
                        case 88:
                            button.setIcon(new ImageIcon(torreBlancaIcon.getImage()));
                            //colorDePiezas.put(button, true);
                            break;
                    }
                } else {
                    panel.setBackground(new Color(65, 56, 56));
                    switch (i) {
                        case 12:
                            button.setIcon(new ImageIcon(caballoNegroIcon.getImage()));
                            break;
                        case 14:
                            button.setIcon(new ImageIcon(reinaNegraIcon.getImage()));
                            break;
                        case 16:
                            button.setIcon(new ImageIcon(alfilNegroIcon.getImage()));
                            break;
                        case 18:
                            button.setIcon(new ImageIcon(torreNegraIcon.getImage()));
                            break;
                        case 81:
                            button.setIcon(new ImageIcon(torreBlancaIcon.getImage()));
                            break;
                        case 83:
                            button.setIcon(new ImageIcon(alfilBlancoIcon.getImage()));
                            break;
                        case 85:
                            button.setIcon(new ImageIcon(reyBlancoIcon.getImage()));
                            break;
                        case 87:
                            button.setIcon(new ImageIcon(caballoBlancoIcon.getImage()));
                            break;
                    }
                }
                if (i >= 21 && i <= 28){
                    button.setIcon(peonNegroIcon);
                }
                if (i >= 71 && i <= 78){
                    button.setIcon(peonBlancoIcon);
                }
                chess.add(panel);
                buttons[i / 10][i % 10] = button;
            }
        }
        return buttons;
    }


    private static Point obtenerPosicionDeBoton(JButton boton) {
        // Recorrer el arreglo de botones para encontrar la posición del botón
        for (int fila = 0; fila < buttons.length; fila++) {
            for (int columna = 0; columna < buttons[fila].length; columna++) {
                if (buttons[fila][columna] == boton) {
                    return new Point(fila, columna);
                }
            }
        }
        return null; // Retorna null si el botón no se encuentra en el arreglo
    }
    public static void frame() {
        JFrame frame = new JFrame("Ajedrez");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,700);

        // Panel para el tablero de ajedrez
        JPanel chess = new JPanel();
        chess.setLayout(new GridLayout(10,10));
        inicializarTablero(chess);

        int tamañoCelda = 50;
        int ancho = tamañoCelda * 10;
        int alto = tamañoCelda * 10 + 100; // 100 píxeles adicionales para otros componentes/controladores

        frame.setSize(ancho, alto);

        // Panel para los controles de entrada
        JPanel controlPanel = new JPanel();
        JTextField origenField = new JTextField(5);
        JTextField destinoField = new JTextField(5);
        JButton moverButton = new JButton("Mover");

        controlPanel.add(new JLabel("Origen:"));
        controlPanel.add(origenField);
        controlPanel.add(new JLabel("Destino:"));
        controlPanel.add(destinoField);
        controlPanel.add(moverButton);

        // Agregar acción al botón de mover
        moverButton.addActionListener(e -> realizarMovimiento(origenField.getText(), destinoField.getText()));

        frame.getContentPane().add(BorderLayout.CENTER, chess);
        frame.getContentPane().add(BorderLayout.SOUTH, controlPanel);
        frame.setResizable(false);
        frame.setVisible(true);
    }


    // Pablo Metodo para no comerse las mismas piezas
    private static class MyActionListener implements ActionListener {
        private Point obtenerPosicionDeBoton(JButton boton) {
            // Recorrer el arreglo de botones para encontrar la posición del botón
            for (int fila = 0; fila < buttons.length; fila++) {
                for (int columna = 0; columna < buttons[fila].length; columna++) {
                    if (buttons[fila][columna] == boton) {
                        return new Point(fila, columna);
                    }
                }
            }
            return null; // Retorna null si el botón no se encuentra en el arreglo
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            if (selectedButton == null) {
                // Selecciona la pieza si corresponde al turno correcto
                if (esTurnoCorrecto(clickedButton)) {
                    selectedButton = clickedButton;
                    iniciarAnimacion(clickedButton); // Iniciar animación
                } else {
                    JOptionPane.showMessageDialog(null, "No es el turno de este color.");
                }
            } else {
                // Realiza el movimiento si es válido
                if (esMovimientoValido(selectedButton, clickedButton)) {
                    detenerAnimacion(); // Detener animación antes de mover la pieza

                    Icon selectedIcon = selectedButton.getIcon();
                    selectedButton.setIcon(null);
                    clickedButton.setIcon(selectedIcon);
                    selectedButton = null;

                    isWhiteTurn = !isWhiteTurn; // Cambia el turno
                    disableAllButtonsExceptCurrentTurn();  // Deshabilita los botones según el turno actual
                } else {
                    JOptionPane.showMessageDialog(null, "Movimiento inválido.");
                }
            }
        }

        private boolean esTurnoCorrecto(JButton button) {
            Icon icono = button.getIcon();
            if (icono instanceof ImageIcon) {
                String nombreIcono = ((ImageIcon) icono).getDescription();
                boolean esPiezaBlanca = nombreIcono.contains("Blanco");
                boolean esPiezaNegra = nombreIcono.contains("Negro");
                return (esPiezaBlanca && isWhiteTurn) || (esPiezaNegra && !isWhiteTurn);
            }
            return false;
        }

        private static void animarPieza(JButton pieza) {
            int tamañoActual = pieza.getPreferredSize().width;
            if (aumentando && tamañoActual < TAMAÑO_MAXIMO) {
                pieza.setPreferredSize(new Dimension(tamañoActual + 1, tamañoActual + 1));
            } else if (!aumentando && tamañoActual > TAMAÑO_ORIGINAL) {
                pieza.setPreferredSize(new Dimension(tamañoActual - 1, tamañoActual - 1));
            } else {
                aumentando = !aumentando;
            }
            pieza.revalidate();
        }
        private static void iniciarAnimacion(JButton pieza) {
            if (animacionTimer != null) {
                animacionTimer.stop();
            }
            animacionTimer = new Timer(100, e -> animarPieza(pieza));
            animacionTimer.start();
        }

        private static void detenerAnimacion() {
            if (animacionTimer != null) {
                animacionTimer.stop();
                animacionTimer = null;
            }
        }


        private boolean esMovimientoValido(JButton origen, JButton destino) {
            Icon iconoOrigen = origen.getIcon();
            Icon iconoDestino = destino.getIcon();

            // Verificar si la casilla de destino está vacía o contiene una pieza del color opuesto
            if (iconoOrigen != null && (iconoDestino == null || !esMismoColor(iconoOrigen, iconoDestino))) {
                return true;
            }

            // Si la casilla de destino está ocupada por una pieza del mismo color, el movimiento no es válido
            return false;
        }

        private boolean esMismoColor(Icon icono1, Icon icono2) {
            if (icono1 instanceof ImageIcon && icono2 instanceof ImageIcon) {
                String nombreIcono1 = ((ImageIcon) icono1).getDescription();
                String nombreIcono2 = ((ImageIcon) icono2).getDescription();

                boolean esPiezaBlanca1 = nombreIcono1.contains("Blanco");
                boolean esPiezaBlanca2 = nombreIcono2.contains("Blanco");

                return esPiezaBlanca1 == esPiezaBlanca2;
            }

            return false;
        }



    }

    private static void disableAllButtonsExceptCurrentTurn() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                JButton button = buttons[i][j];
                if (button != null) {
                    Icon icon = button.getIcon();
                    if (icon instanceof ImageIcon) {
                        String descripcion = ((ImageIcon) icon).getDescription();
                        // Verifica que la descripción no sea null antes de llamar a contains
                        if (descripcion != null) {
                            boolean esPiezaBlanca = descripcion.contains("Blanco");
                            button.setEnabled(isWhiteTurn ? esPiezaBlanca : !esPiezaBlanca);
                        } else {
                            // Si la descripción es null, puedes decidir qué hacer
                            // Por ejemplo, deshabilitar el botón
                            button.setEnabled(false);
                        }
                    }
                }
            }
        }
    }

    private static void realizarMovimiento(String origen, String destino) {
        // Validar y convertir las coordenadas de origen y destino
        // Por ejemplo, convertir "A2" a la posición correspondiente en el arreglo de botones
        Point origenPoint = convertirCoordenadas(origen);
        Point destinoPoint = convertirCoordenadas(destino);

        if (origenPoint != null && destinoPoint != null) {
            JButton botonOrigen = buttons[origenPoint.x][origenPoint.y];
            JButton botonDestino = buttons[destinoPoint.x][destinoPoint.y];

            // Aquí puedes reutilizar tu lógica existente para realizar el movimiento
            // Por ejemplo, verificar si el movimiento es válido y actualizar el tablero
        } else {
            // Mostrar un mensaje de error si las coordenadas no son válidas
            JOptionPane.showMessageDialog(null, "Coordenadas inválidas.");
        }
    }

    private static Point convertirCoordenadas(String coordenada) {
        if (coordenada.length() != 2) {
            return null;
        }
        int columna = coordenada.charAt(0) - 'A'; // Convertir 'A' a 0, 'B' a 1, etc.
        int fila = '8' - coordenada.charAt(1); // Convertir '8' a 0, '7' a 1, etc.
        if (columna < 0 || columna >= 8 || fila < 0 || fila >= 8) {
            return null;
        }
        return new Point(fila, columna);
    }





    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> frame());
    }
}
