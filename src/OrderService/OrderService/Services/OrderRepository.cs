using Newtonsoft.Json;
using StackExchange.Redis;

namespace OrderService.Services;

public class OrderRepository : IOrderRepository
{
    private readonly ConnectionMultiplexer _redisConnection;

    public OrderRepository()
    {
        _redisConnection = ConnectionMultiplexer.Connect("orderstore:6379");
    }

    public Order GetOrderAsync(int id)
    {
        var redisDb = _redisConnection.GetDatabase();

        // Retrieve the serialized object from Redis and deserialize it
        string serializedOrder = redisDb.StringGet($"Order:{id}");

        if (serializedOrder == RedisValue.Null)
        {
            // The object was not found in the cache
            return null;
        }

        Order order = JsonConvert.DeserializeObject<Order>(serializedOrder);

        return order;
    }

    public void StoreOrderAsync(Order order)
    {
        var redisDb = _redisConnection.GetDatabase();

        // Serialize the Order object to JSON or any other format of your choice
        string serializedOrder = JsonConvert.SerializeObject(order);

        // Store the serialized object in Redis with a key
        redisDb.StringSet($"Order:{order.Id}", serializedOrder);
    }


}
