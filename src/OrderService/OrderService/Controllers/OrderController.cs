using Confluent.Kafka;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using OrderService.Services;
using System.Diagnostics;
using System.Net;
using System.Text.Json;

namespace OrderService.Controllers;

[ApiController]
[Route("[controller]")]
public class OrderController : ControllerBase
{
    private readonly string BrokerServer = "broker:9092";
    private readonly string Topic = "order";
    private readonly ILogger<OrderController> _logger;
    private readonly IOrderRepository _orderRepository;
    public OrderController(ILogger<OrderController> logger, IOrderRepository orderRepository)
    {
        _logger = logger;
        _orderRepository = orderRepository;
    }

    [HttpGet("status")]
    public string Status()
    {
        return "Connected Order-Service API";
    }

    [HttpGet("{id}")]
    public Order Get(int id)
    {
        var order = _orderRepository.GetOrderAsync(id);

        return order;

    }

    [HttpPost]
    public async Task<IActionResult> Post([FromBody] Order orderRequest)
    {
        string message = JsonSerializer.Serialize(orderRequest);
        //_orderRepository.StoreOrderAsync(orderRequest);
        return Ok(await SendOrderRequest(Topic, message));
    }
    private async Task<bool> SendOrderRequest(string topic, string message)
    {
        ProducerConfig config = new ProducerConfig
        {
            BootstrapServers = BrokerServer,
            ClientId = Dns.GetHostName()
        };

        try
        {
            using (var producer = new ProducerBuilder<Null, string>(config).Build())
            {
                var result = await producer.ProduceAsync
                (topic, new Message<Null, string>
                {
                    Value = message
                });

                Console.WriteLine($"Delivery Timestamp:{result.Timestamp.UtcDateTime}");
                return await Task.FromResult(true);
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error occured: {ex.Message}");
        }

        return await Task.FromResult(false);
    }
}
