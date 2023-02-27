
import torch
import torch.nn as nn

class Main():
    device = "cuda" if torch.cuda.is_available() else "cpu"
    print(f"Using {device} device")
    #xor
    #inputs 
    x = torch.Tensor([[0,0],[0,1],[1,0],[1,1]])
    #outputs
    y = torch.Tensor([[0],[1],[1],[0]])

    def get_device(self):
        return self.device