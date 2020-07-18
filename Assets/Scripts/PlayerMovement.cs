using UnityEngine;

public class PlayerMovement : MonoBehaviour
{
    // Start is called before the first frame update
    
    public Rigidbody rb;
    
    public float forwardForce = 2000f;
    public float sidewaysForce = 500f;

 

    // Update is called once per frame
    // We marked this as FixedUpdate because we are 
    // using it to mess with physics
    void FixedUpdate()
    {
        // adding forward force
        rb.AddForce(0, 0, forwardForce * Time.deltaTime);

        if(Input.GetKey("d")){//If the player presses "d" key
            // add force to the left
            rb.AddForce(sidewaysForce * Time.deltaTime, 0 , 0, ForceMode.VelocityChange);
        }
        
        if(Input.GetKey("a")){//If the player presses "a" key
            // add force to the left
            rb.AddForce(-sidewaysForce * Time.deltaTime, 0 , 0, ForceMode.VelocityChange);
        }

        if(rb.position.y < -1f){
            FindObjectOfType<GameManager>().EndGame();
        }

    }
}
