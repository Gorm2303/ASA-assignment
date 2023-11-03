namespace OrderService.Services
{
    public interface IOrderRepository
    {
        void StoreOrderAsync(Order order);
        Order GetOrderAsync(string id);
    }
}
