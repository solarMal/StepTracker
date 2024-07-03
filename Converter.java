public class Converter {

    //Преобразование шагов в километры
    int convertToKm(int steps) {
        return ((steps * 75) / 100) / 1000;
    }

    //Преобразование шагов в килокалории
    int convertStepsToKilocalories(int steps) {
        return (steps * 50) / 1000;
    }
}
