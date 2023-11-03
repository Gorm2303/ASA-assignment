using StackExchange.Redis;

namespace OrderService.Services;

public class OrderRepository : IOrderRepository
{
    private readonly IDatabase _db;
    private readonly ConnectionMultiplexer _redis;
    public OrderRepository()
    {
        _redis = ConnectionMultiplexer.Connect("localhost");
        _db = _redis.GetDatabase();
    }

    public Order GetOrderAsync(string id)
    {
        throw new NotImplementedException();
    }

    public void StoreOrderAsync(Order order)
    {
        throw new NotImplementedException();
    }
}
