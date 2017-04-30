namespace Server.domain
{
    public interface IHasId<T>
    {
        T Id { get; set; }
    }
}
