package Train.Middian.Problem4;

public interface Methods<T> {
    public void add(T elem);
    public T get(int index);
    public void remove(int index);
    public int getSize();
    public void forEach(ForEach<T> f);

}
