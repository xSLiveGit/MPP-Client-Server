package dto;

import Generated.Protobuf.MatchDTO;
import Generated.Protobuf.SaleDTO;
import Generated.Protobuf.UserDTO;
import entity.Match;
import entity.Sale;
import entity.User;
import exceptions.EntityArgumentException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergiu on 3/30/2017.
 */
public class DTOUtils {
    public static User getFromDTO( Generated.Protobuf.UserDTO usdto){
        String id=usdto.getId();
        String pass=usdto.getPassword();
        return new User(id, pass);

    }
    public static UserDTO getDTO(User user){
        String id=user.getId();
        String pass=user.getPassword();
        UserDTO userDTO = UserDTO
                .newBuilder()
                .setId(user.getId())
                .setPassword(user.getPassword())
                .build();
        return userDTO;
    }

    public static SaleDTO getDTO(Sale sale, String username){
        return SaleDTO
                .newBuilder()
                .setIdMatch(sale.getIdMatch().toString())
                .setPerson(sale.getPerson())
                .setQuantity(sale.getQuantity())
                .setUsername(username)
                .build();
    }

    public static Sale getFromDTO(SaleDTO salesDTO){
        return new Sale(Integer.parseInt(salesDTO.getIdMatch()),salesDTO.getQuantity(),salesDTO.getPerson());
    }

    public static MatchDTO getDTO(Match match){
        return MatchDTO
                .newBuilder()
                .setId(match.getId())
                .setPrice(match.getPrice())
                .setStage(match.getStage())
                .setTickets(match.getTickets())
                .setTeam1(match.getTeam1())
                .setTeam2(match.getTeam2())
                .build();
    }

    public static Match getFromDTO(MatchDTO matchDTO)  {
        Integer id = matchDTO.getId();
        String team1 =  matchDTO.getTeam1();
        String team2 = matchDTO.getTeam2();
        String stage = matchDTO.getStage();
        Integer tickets = matchDTO.getTickets();
        Double price = matchDTO.getPrice();
        try {
            return new Match(id,team1,team2,stage,tickets,price);
        } catch (EntityArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static UserDTO[] getDTO(User[] users){
        UserDTO[] usrDTO=new UserDTO[users.length];
        for(int i=0;i<users.length;i++)
            usrDTO[i]=getDTO(users[i]);
        return usrDTO;
    }

    public static User[] getFromDTO(UserDTO[] users){
        User[] usr=new User[users.length];
        for(int i=0;i<users.length;i++){
            usr[i]=getFromDTO(users[i]);
        }
        return usr;
    }

    public static List<Match> getMatchesListFromDTO(List<MatchDTO> list){
        List<Match> listM = new ArrayList<>();
        list.forEach(el->listM.add(getFromDTO(el)));
        return listM;
    }


}
