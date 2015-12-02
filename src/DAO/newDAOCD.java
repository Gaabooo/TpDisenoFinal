package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import modelo.*;

public class newDAOCD {
    public static int getIDEstado(Estado unEstado) {
        int unIDEstado = 0;
        String getIDEstado = "SELECT id_estado FROM estado WHERE nombre = '" + unEstado.getNombre() + "'";
        Connection conn = null; 
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getIDEstado);
            while (rs.next()) {
                unIDEstado = rs.getInt("id_estado"); }
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unIDEstado; }
    
    public static int getIDParticipante(Participante unParticipante) {
        int unIDParticipante = 0;
        String getIDParticipante = "SELECT id_participante FROM participante WHERE nombre = '" + unParticipante.getNombre() + "'";
        Connection conn = null; 
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getIDParticipante);
            while (rs.next()) {
                unIDParticipante = rs.getInt("id_participante"); }
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unIDParticipante; }
    
    public static void deletePartidos(int unIDRonda) {
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String deletePartidos = "DELETE FROM partido WHERE id_ronda = " + unIDRonda;
            System.out.println("Borre los partidos de la ronda: " + unIDRonda);
            statement.executeUpdate(deletePartidos); }
        catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } } }
    
    public static void deleteRondas(int unIDFixture) {
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getIDRonda = "SELECT id_ronda FROM ronda WHERE id_fixture = " + unIDFixture;
            ArrayList<Integer> listaIDRondas = new ArrayList<>();
            ResultSet rs = statement.executeQuery(getIDRonda);
            while (rs.next()) {
                listaIDRondas.add(rs.getInt("id_ronda")); }
            rs.close();
            for (Integer IDRonda:listaIDRondas) {
                System.out.println("- IDRonda: " + IDRonda);
                deletePartidos(IDRonda); }
            String deleteRondas = "DELETE FROM ronda WHERE id_fixture = " + unIDFixture;
            System.out.println("Borre las rondas del fixture: " + unIDFixture);
            statement.executeUpdate(deleteRondas); }
        catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } } }
    
    public static void deleteFixture(Competencia unaCompetencia) {
        Connection conn = null; 
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            int IDCD = getIDCompetencia(unaCompetencia);
            int IDFixture = 0;
            String getIDFixture = "SELECT id_fixture FROM fixture WHERE id_competencia = " + IDCD;
            ResultSet rs = statement.executeQuery(getIDFixture);
            // NOTA: El ResultSet solo contiene un resultado
            while (rs.next()) {
                IDFixture = rs.getInt("id_fixture"); }
            rs.close();
            deleteRondas(IDFixture);
            String deleteFixture = "DELETE FROM fixture WHERE id_fixture = " + IDFixture;
            System.out.println("Borre el fixture: " + IDFixture);
            statement.executeUpdate(deleteFixture); }
        catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } } }
    
    public static int getIDCompetencia(Competencia unaCompetencia) {
        int unIDCD = 0;
        String getIDCD = "SELECT id_competencia FROM competencia WHERE nombre = '" + unaCompetencia.getNombre() + "'";
        Connection conn = null; 
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getIDCD);
            while (rs.next()) {
                unIDCD = rs.getInt("id_competencia"); }
            rs.close();}
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unIDCD; }
    
    public static int getIDLR(LugarRealizacion unLR) {
        int unIDLR = 0;
        String getIDLR = "SELECT id_lugar FROM lugar WHERE nombre = '" + unLR.getNombre() + "'";
        Connection conn = null; 
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getIDLR);
            while (rs.next()) {
                unIDLR = rs.getInt("id_lugar"); }
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unIDLR; }
    
    public static void persistirPartido(Partido unPartido, int IDRonda) {
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            // Busqueda de IDs necesarias
            Participante P0 = unPartido.getP0();
            Participante P1 = unPartido.getP1();
            LugarRealizacion LR = unPartido.getLR();
            int IDP0 = getIDParticipante(P0);
            int IDP1 = getIDParticipante(P1);
            int IDLR = getIDLR(LR);
            // Persistencia partido
            String persistirPartido = "INSERT INTO partido VALUES (default, " + IDRonda + ", " + IDP0 + ", " + IDP1 + ", " + IDLR + ", " + unPartido.getEmpatePermitido() + ", " + unPartido.getRondaPerdedores() + ", null, null)";
            statement.executeUpdate(persistirPartido); }
        catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } } }
    
    public static void persistirRonda(Ronda unaRonda, int IDFixture) {
        int IDRonda = 0;
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            // Persistencia ronda
            String persistirRonda = "INSERT INTO ronda VALUES (default, " + IDFixture + ", " + unaRonda.getFecha() + ", " + unaRonda.getNumeroRonda() + ")";
            statement.executeUpdate(persistirRonda);
            // Obtengo IDRonda para persistir los partidos
            String getIDRonda = "SELECT id_ronda FROM ronda WHERE id_fixture = " + IDFixture;
            ResultSet rs = statement.executeQuery(getIDRonda);
            // NOTA: El ResultSet solo contiene un resultado
            while (rs.next()) {
                IDRonda = rs.getInt("id_ronda"); }
            // Persistencia partidos
            for (Partido unPartido:(unaRonda.getListaPartidos())) {
                persistirPartido(unPartido, IDRonda); }
            rs.close(); }
        catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } } }
    
    public static void persistirFixture(Fixture unFixture, String nombreCD) {
        int IDCD = 0; int IDFixture = 0;
        Connection conn = null; 
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            // Obtengo IDCD para persistir el fixture
            String getIDCompetencia = "SELECT id_competencia FROM competencia WHERE nombre = '" + nombreCD + "'";
            ResultSet rs = statement.executeQuery(getIDCompetencia);
            // NOTA: El ResultSet solo contiene un resultado
            while (rs.next()) {
                IDCD = rs.getInt("id_competencia"); }
            // Persistencia fixture
            String persistirFixture = "INSERT INTO fixture VALUES (default, " + IDCD + ")";
            statement.executeUpdate(persistirFixture);
            // Obtengo IDFixture para persistir la ronda
            String getIDFixture = "SELECT id_fixture FROM fixture WHERE id_competencia = " + IDCD;
            rs = statement.executeQuery(getIDFixture);
            // NOTA: El ResultSet solo contiene un resultado
            while (rs.next()) {
                IDFixture = rs.getInt("id_fixture"); }
            // Persistencia rondas
            for (Ronda unaRonda:(unFixture.getListaRondas())) {
                persistirRonda(unaRonda, IDFixture); }
            rs.close(); }
        catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } } }
    
    public static ArrayList<HistorialParticipante> getHistorialParticipante(int unIDParticipante) {
        ArrayList<HistorialParticipante> historial = new ArrayList();
        HistorialParticipante unCambio;
        String nombre, correo; Date fecha; Time hora;
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getHistorial = "SELECT * FROM historial_participante WHERE id_participante = " + unIDParticipante;
            ResultSet rs = statement.executeQuery(getHistorial);
            while (rs.next()) {
                nombre = rs.getString("nombre");
                correo = rs.getString("correo");
                fecha = rs.getDate("fecha");
                hora = rs.getTime("hora");
                unCambio = new HistorialParticipante(nombre, correo, fecha, hora);
                historial.add(unCambio); }
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return historial; }    
    
    public static ArrayList<Participante> getParticipantes(int unIDCompetencia) {
        ArrayList<Participante> listaParticipantes = new ArrayList();
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getParticipantes = "SELECT * FROM participante WHERE id_competencia = " + unIDCompetencia;
            ResultSet rs = statement.executeQuery(getParticipantes);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                int IDParticipante = rs.getInt("id_participante");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo_electronico");
                ArrayList<HistorialParticipante> historial = getHistorialParticipante(IDParticipante);
                Participante unParticipante = new Participante(nombre, correo, historial);
                listaParticipantes.add(unParticipante); }
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return listaParticipantes; }
    
    public static ArrayList<Disponibilidad> getDisponibilidades(int unIDCompetencia) {
        ArrayList<Disponibilidad> listaDisponibilidades = new ArrayList();
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getDisponibilidades = "SELECT * FROM disponibilidad WHERE id_competencia = " + unIDCompetencia;
            ResultSet rs = statement.executeQuery(getDisponibilidades);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                int IDLugar = rs.getInt("id_lugar");
                LugarRealizacion unLugarRealizacion = getLugarRealizacion(IDLugar);
                int cantPartidos = rs.getInt("cantidad");
                Disponibilidad unaDisponibilidad = new Disponibilidad(cantPartidos, unLugarRealizacion);
                listaDisponibilidades.add(unaDisponibilidad); }
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return listaDisponibilidades; }
    
    public static ArrayList<Deporte> getDeportes(int unIDLR) {
        ArrayList<Integer> listaIDDeportes = new ArrayList();
        ArrayList<Deporte> listaDeportes = new ArrayList();
        Deporte unDeporte;
        int IDDeporte;
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getDeportes = "SELECT id_deporte FROM lugar_realiza_deporte WHERE id_lugar = " + unIDLR;
            ResultSet rs = statement.executeQuery(getDeportes);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                IDDeporte = rs.getInt("id_deporte");
                listaIDDeportes.add(IDDeporte); }
            // Busqueda deportes por ID
            for (Integer unIDDeporte:listaIDDeportes) {
                unDeporte = getDeporte(unIDDeporte);
                listaDeportes.add(unDeporte); }
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return listaDeportes; }
    
    public static LugarRealizacion getLugarRealizacion(int unID) {
        LugarRealizacion unLR = null;
        int IDLR = 0; String nombreLR = ""; String descripcionLR = "";
        ArrayList<Deporte> listaDeportes;
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getLR = "SELECT * FROM lugar WHERE id_lugar = " + unID;
            ResultSet rs = statement.executeQuery(getLR);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                IDLR = rs.getInt("id_lugar");
                nombreLR = rs.getString("nombre");
                descripcionLR = rs.getString("descripcion"); }
            // Busqueda de deportes
            listaDeportes = getDeportes(IDLR);
            unLR = new LugarRealizacion(IDLR, nombreLR, descripcionLR, listaDeportes);
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unLR; }
    
    public static Deporte getDeporte(int unID) {
        Deporte unDeporte = null;
        int IDDeporte = 0;
        String nombreDeporte = "";
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getIDDeporte = "SELECT * FROM deporte WHERE id_deporte = " + unID;
            ResultSet rs = statement.executeQuery(getIDDeporte);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                IDDeporte = rs.getInt("id_deporte");
                nombreDeporte = rs.getString("nombre"); }
            unDeporte = new Deporte(IDDeporte, nombreDeporte);
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unDeporte; }
    
    public static Modalidad getModalidad(int unID) {
        Modalidad unaModalidad = null;
        int IDModalidad = 0;
        String nombreModalidad = "";
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getIDModalidad = "SELECT * FROM modalidad WHERE id_modalidad = " + unID;
            ResultSet rs = statement.executeQuery(getIDModalidad);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                IDModalidad = rs.getInt("id_modalidad");
                nombreModalidad = rs.getString("nombre"); }
            unaModalidad = new Modalidad(IDModalidad, nombreModalidad);
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unaModalidad; }
    
    public static void setEstado(Competencia unaCompetencia, Estado unEstado) {
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            int IDEstado = getIDEstado(unEstado);
            String nombreCD = unaCompetencia.getNombre();
            String getIDEstado = "UPDATE competencia SET id_estado = " + IDEstado + " WHERE nombre = '" + nombreCD + "'";
            ResultSet rs = statement.executeQuery(getIDEstado);
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } } }
    
    public static Estado getEstado(int unID) {
        Estado unEstado = null;
        int IDEstado = 0;
        String nombreEstado = "";
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getIDEstado = "SELECT * FROM estado WHERE id_estado = " + unID;
            ResultSet rs = statement.executeQuery(getIDEstado);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                IDEstado = rs.getInt("id_estado");
                nombreEstado = rs.getString("nombre"); }
            unEstado = new Estado(nombreEstado);
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unEstado; }
    
    public static Estado getEstado(String unNombre) {
        Estado unEstado = null;
        int IDEstado; String nombreEstado = "";
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getIDEstado = "SELECT * FROM estado WHERE nombre = '" + unNombre + "'";
            ResultSet rs = statement.executeQuery(getIDEstado);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                IDEstado = rs.getInt("id_estado");
                nombreEstado = rs.getString("nombre"); }
            unEstado = new Estado(nombreEstado);
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unEstado; }
    
    public static FormaPuntuacion getFormaPuntuacion(int unID) {
        FormaPuntuacion unaFormaPuntuacion = null;
        int IDFormaPuntuacion = 0;
        String nombreFormaPuntuacion = "";
        Connection conn = null;
        try {
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            String getIDFormaPuntuacion = "SELECT * FROM forma_puntuacion WHERE id_forma_puntuacion = " + unID;
            ResultSet rs = statement.executeQuery(getIDFormaPuntuacion);
            // El ResultSet tiene un solo resultado
            while (rs.next()) {
                IDFormaPuntuacion = rs.getInt("id_forma_puntuacion");
                nombreFormaPuntuacion = rs.getString("nombre"); }
            unaFormaPuntuacion = new FormaPuntuacion(IDFormaPuntuacion, nombreFormaPuntuacion);
            rs.close(); }
        catch (SQLException ex) { System.out.println(ex.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return unaFormaPuntuacion; }        
        
    public static Competencia getCompetencia(String nombreCD) {
        String _SQL_FIND_CDBYNAME = "SELECT * FROM competencia WHERE nombre = '" + nombreCD + "'";
        Connection conn = null;
        Competencia retorno = null;
        try {
            // Variables auxiliares
            String unNombre = ""; String unReglamento = "";
            int IDCompetencia = 0; int IDUsuario = 0; int IDEstado = 0; int IDFormaPuntuacion = 0; int IDModalidad = 0; int IDDeporte = 0;
            Deporte unDeporte; Modalidad unaModalidad; Estado unEstado; FormaPuntuacion unaFormaPuntuacion;
            ArrayList<Disponibilidad> listaDisponibilidades; ArrayList<Participante> listaParticipantes; ArrayList<TablaPosicionesParticipante> listaTablasPosiciones = null;
            int cantMaxSets = 0; int tantosAusenciaRival = 0; int ptosPresentacion = 0; int ptosVictoria = 0; int ptosEmpate = 0;
            Boolean permisoEmpate = false;
            // Busqueda de la competencia
            conn = DBConnection.get();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(_SQL_FIND_CDBYNAME);
            while(rs.next()) {
                IDCompetencia = rs.getInt("id_competencia"); IDUsuario = rs.getInt("id_usuario");
                IDEstado = rs.getInt("id_estado"); IDFormaPuntuacion = rs.getInt("id_forma_puntuacion");
                IDModalidad = rs.getInt("id_modalidad"); IDDeporte = rs.getInt("id_deporte");
                unNombre = rs.getString("nombre"); unReglamento = rs.getString("reglamento");
                cantMaxSets = rs.getInt("cantidad_maxima_de_sets"); tantosAusenciaRival = rs.getInt("tantos_por_ausencia_rival"); /**/
                ptosPresentacion = rs.getInt("puntos_por_presentacion"); ptosVictoria = rs.getInt("puntos_por_victoria");
                permisoEmpate = rs.getBoolean("empate_permitido"); ptosEmpate = rs.getInt("puntos_por_empate"); }
            /* while(rs.next()) {
                unNombre = rs.getString("nombre"); unReglamento = rs.getString("reglamento");
                IDCompetencia = rs.getInt("id_competencia"); IDUsuario = rs.getInt("id_usuario");
                IDEstado = rs.getInt("id_estado"); IDFormaPuntuacion = rs.getInt("id_forma_puntuacion");
                IDModalidad = rs.getInt("id_modalidad"); IDDeporte = rs.getInt("id_deporte");
                cantMaxSets = rs.getInt("cantidad_maxima_de_sets"); tantosAusenciaRival = rs.getInt("tantos_por_ausencia_rival");
                ptosPresentacion = rs.getInt("puntos_por_presentacion"); ptosVictoria = rs.getInt("puntos_por_victoria");
                permisoEmpate = rs.getBoolean("empate_permitido"); ptosEmpate = rs.getInt("puntos_por_empate"); } */
            // Busqueda de: Deporte, Modalidad, Estado, FormaPuntuacion
            unDeporte = getDeporte(IDDeporte);
            unaModalidad = getModalidad(IDModalidad);
            unEstado = getEstado(IDEstado);
            unaFormaPuntuacion = getFormaPuntuacion(IDFormaPuntuacion);
            // Busqueda de: listaDisponibilidades, listaParticipantes
            listaDisponibilidades = getDisponibilidades(IDCompetencia);
            listaParticipantes = getParticipantes(IDCompetencia);
            // Creacion del retorno
            retorno = new Competencia(IDUsuario, unNombre, unReglamento, unDeporte, unaModalidad, unEstado, unaFormaPuntuacion,
                listaDisponibilidades, listaParticipantes, listaTablasPosiciones,
                cantMaxSets, tantosAusenciaRival, ptosPresentacion, ptosVictoria, permisoEmpate, ptosEmpate);
            rs.close(); }
        catch (SQLException e) {
            System.out.println(e.getMessage()); }
        finally {
            if (conn != null) try { conn.close(); }
            catch (SQLException ex) { System.out.println(ex.getMessage()); } }
        return retorno; } }