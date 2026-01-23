package Java10x.Itau.Estatisticas;

public record EstataisticaDTO(
        Long count,
        Double avg,
        Double max,
        Double min,
        Double sum


) {
    public EstataisticaDTO(Long count, Double avg, Double max, Double min, Double sum) {
        this.count = count;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.sum = sum;
    }
}
