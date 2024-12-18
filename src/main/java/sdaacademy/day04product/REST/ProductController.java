package sdaacademy.day04product.REST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

  private List<Product> products = new ArrayList<>();

    // GET - obtinem toate produsele
    // Această metodă returnează întreaga listă de produse.
    @GetMapping
    public List<Product> getAllProducts(){
        return products;
    }

    // POST - creez un produs nou , ca raspuns status 201 si un mesaj de succes in body
    // Această metodă adaugă un produs nou în lista de produse și returnează un răspuns cu statusul HTTP 201 (creat) și un mesaj de succes
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        products.add(product);
        return ResponseEntity.status(201).body("Produs a fost adaugat cu succes");
    }

    // PUT - actualizez un produs existent pe baza unui ID pe care il specific in URL
    // de ex: localhost:8080/api/products/1 sau localhost:8080/api/products/2 sau ...

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product updatedProduct){
        for (Product product : products){
            // Verificăm dacă produsul cu ID-ul specificat există.
            if (product.getId() ==  id) {
                // Actualizăm numele și prețul produsului.
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                return ResponseEntity.ok("Proodusul a fost actualizat cu succes");
            }
        }
        // Dacă produsul nu a fost găsit, returnăm un răspuns cu status 404.
        return ResponseEntity.status(404).body("Produsul cu ID-ul: " + id + " nu a fost gasit");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
// Optiunea A : folosind streamuri:
//        List<Product> filteredProducts = products.stream()
//                .filter(product -> product.getId() != id) // filtrat produse, am pastrat doar cele cu id diferit decat cel specificat in path
//                .collect(Collectors.toList()); // am colectat rezultatul intr-o lista
//
//        if (filteredProducts.size() < products.size()){
//            products = filteredProducts;
//            return ResponseEntity.ok("Produsul a fost sters cu succes");
//        } else {
//            return ResponseEntity.status(404).body("Produsul cu ID-ul " + id + " nu a fost gasit");
//        }
// Optiunea B: folosind removeIf
// Folosim `removeIf` pentru a elimina produsul cu ID-ul specificat din lista de produse.
      boolean removed =   products.removeIf(product -> product.getId() == id);
        // Dacă produsul a fost șters, returnăm un răspuns cu statusul 200 și un mesaj de succes.
      if (removed) {
          return ResponseEntity.ok("Produsul a fost sters cu succes");
      } else {
          // Dacă produsul nu a fost găsit, returnăm un răspuns cu status 404 și un mesaj de eroare.
          return ResponseEntity.status(404).body("Produsul cu ID-ul " + id + " nu a fost gasit");
      }
    }



}
