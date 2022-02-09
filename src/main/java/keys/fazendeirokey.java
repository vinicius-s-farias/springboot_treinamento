//package keys;
//
//import br.com.solinftec.treinamentospringboot.model.Fazendeiro;
//import lombok.Data;
//
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Data
//public class fazendeirokey implements Serializable {
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        fazendeirokey that = (fazendeirokey) o;
//        return fazendeiro.equals(that.fazendeiro);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(fazendeiro);
//    }
//
//    public fazendeirokey(Fazendeiro fazendeiro) {
//        this.fazendeiro = fazendeiro;
//    }
//}
