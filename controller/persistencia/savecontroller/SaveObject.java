package controller.persistencia.savecontroller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class SaveObject {
    private File arquivo;
    private Gson gson;
    
    public SaveObject(String nomeArquivo) {
        arquivo = new File(nomeArquivo);
        gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    // Salvar um objeto (sobrescreve o arquivo)
    public void salvarObjeto(Object objeto) throws IOException {
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(objeto, writer);
        }
    }
    
    // Salvar uma lista de objetos
    public void salvarLista(List<?> objetos) throws IOException {
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(objetos, writer);
        }
    }
    
    // Adicionar objeto a uma lista existente
    public void adicionarObjeto(Object objeto) throws IOException {
        List<Object> objetos = lerLista(Object.class);
        objetos.add(objeto);
        salvarLista(objetos);
    }
    
    // Ler um único objeto
    public <T> T lerObjeto(Class<T> classe) throws IOException {
        if (!arquivo.exists()) {
            return null;
        }
        
        try (FileReader reader = new FileReader(arquivo)) {
            return gson.fromJson(reader, classe);
        }
    }
    
    // Ler uma lista de objetos
    public <T> List<T> lerLista(Class<T> classe) throws IOException {
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }
        
        try (FileReader reader = new FileReader(arquivo)) {
            Type tipoLista = TypeToken.getParameterized(ArrayList.class, classe).getType();
            List<T> lista = gson.fromJson(reader, tipoLista);
            return lista != null ? lista : new ArrayList<>();
        }
    }
    
    // Verificar se arquivo existe
    public boolean arquivoExiste() {
        return arquivo.exists();
    }
    
    // Deletar arquivo
    public boolean deletarArquivo() {
        return arquivo.exists() && arquivo.delete();
    }
}