using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Confluent.Kafka;

namespace asa.ordersystem.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class OrderController : ControllerBase
    {
        private readonly IProducer<Null, string> _producer;

        public OrderController(IProducer<Null, string> producer)
        {
            _producer = producer;
        }

        [HttpPost]
        public IActionResult Post([FromBody] Order order)
        {
            var message = new Message<Null, string>
            {
                Value = order.ToString()
            };

            _producer.Produce("order", message);

            return Ok();
        }
    }
}
