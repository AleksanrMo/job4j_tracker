package ru.job4j.ex;

public class UserStore {

    @SuppressWarnings("checkstyle:SimplifyBooleanExpression")
    public static User findUser(User[] users, String login) throws UserNotFoundException {

        for (User user : users) {
            if (user.getUserName().equals(login)) {
                return user;
            }
            throw new UserNotFoundException("Пользователь не найден.");
        }
      return null;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUserName().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("Пользователя нет в массиве");
        }
       return true;
    }

    public static void main(String[] args) {

        try {
            User[] users = {
                    new User("Petr", true)
            };
            User user = findUser(users, "Petr");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
           // user.isValid();
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException ei) {
            ei.printStackTrace();
        }
    }
}
