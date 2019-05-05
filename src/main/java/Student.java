import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Entity
@Data
//@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    String name;
    int age;
    
}
