using Confluent.Kafka;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;
using System.Net;
using System.Text.Json;

namespace WebApplication1.Controllers;


[ApiController]
[Route("[Controller]")]
public class OrderController : ControllerBase
{
    private readonly string BrokerServer = "localhost:9092";
    private readonly string Topic = "order";
    private readonly ILogger<OrderController> _logger;

    public OrderController(ILogger<OrderController> logger)
    {
        _logger = logger;
    }

    [HttpGet(Name = "GetOrderService")]
    public string Get()
    {
        return "Order API";
    }

    [HttpPost]
    public async Task<IActionResult> Post([FromBody] Order orderRequest)
    {
        string message = JsonSerializer.Serialize(orderRequest);
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
            using (var producer = new ProducerBuilder
            <Null, string>(config).Build())
            {
                var result = await producer.ProduceAsync
                (topic, new Message<Null, string>
                {
                    Value = message
                });

                Debug.WriteLine($"Delivery Timestamp:{result.Timestamp.UtcDateTime}");
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

