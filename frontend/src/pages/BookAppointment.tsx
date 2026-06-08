import {useParams} from "react-router-dom";
import {useQuery} from "@tanstack/react-query";
import {Field, FieldLabel} from "@/components/ui/field";
import {Input} from "@/components/ui/input";
import {Textarea} from "@/components/ui/textarea";
import {Calendar} from "@/components/ui/calendar";
import {Button} from "@/components/ui/button";
import {useState} from "react";
import {Select, SelectContent, SelectItem, SelectTrigger, SelectValue} from "@/components/ui/select";

interface Slot {
    time: string;
    available: boolean;
}

const BookAppointment = () => {
    const [date, setDate] = useState<Date | undefined>(new Date())
    const [selectedSlot, setSelectedSlot] = useState<string>('');
    const [availableSlots, setAvailableSlots] = useState<Slot[]>([]);
    const {expertId} = useParams();
    const {data, isLoading, error} = useQuery({
        queryKey: ['expertId'],
        queryFn: async () => {
            return {
                id: expertId,
                name: "Mr expert"
            };
        }
    });

    const handleAvailability = async () => {
        const available_slots = await fetchAvailableSlots();
        const times = ['09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00', '16:00', '17:00'];
        setAvailableSlots(
            times.map(time => ({
                time,
                available: available_slots.includes(time),
            }))
        );

    }


    const fetchAvailableSlots = async () => {
        return ['10:00', '11:00', '12:00', '14:00', '16:00'];
    }
    if (isLoading)
        return (<div>loading ....</div>)
    return (
        <section className="container mx-auto mt-16">
            <h1 className="mb-8 font-bold text-2xl">
                Schedule a meeting with <u>{data!.name}</u>
            </h1>
            <div className="grid grid-cols-1 md:grid-cols-2 w-full gap-8">
                <div className="p-6 flex flex-col gap-6">
                    <Field>
                        <FieldLabel htmlFor="fullname">Full Name</FieldLabel>
                        <Input required id="fullname" type="text" placeholder="Full Name" aria-label="Full Name"/>
                    </Field>

                    <Field>
                        <FieldLabel htmlFor="email">Email</FieldLabel>
                        <Input required id="email" type="text" placeholder="Email" aria-label="Email"/>
                    </Field>

                    <Field>
                        <FieldLabel htmlFor="phone">Phone Number</FieldLabel>
                        <Input required id="phone" type="text" placeholder="Phone Number" aria-label="Phone Number"/>
                    </Field>

                    <Field>
                        <FieldLabel htmlFor="more_infos">More</FieldLabel>
                        <Textarea id="more_infos" placeholder="more info about your request."
                                  aria-label="more info about you"></Textarea>
                    </Field>

                </div>
                <div className="p-6 flex flex-col gap-6 justify-between">
                    <div className="w-full flex justify-center">

                        <Calendar
                            mode="single"
                            selected={date}
                            onSelect={handleAvailability}
                            className="min-w-2/3 min-h-2/3 flex border"
                            captionLayout="dropdown"
                        />
                    </div>
                    <div className="w-full flex justify-center">
                        <Select name="time" onValueChange={(value) => setSelectedSlot(value)}>
                            <SelectTrigger>
                                <SelectValue placeholder="Select a time"/>
                            </SelectTrigger>
                            <SelectContent>
                                {availableSlots.map((item) => (
                                    <SelectItem
                                        key={item.time}
                                        disabled={!item.available}
                                        value={item.time}>{item.time}
                                    </SelectItem>
                                ))}
                            </SelectContent>
                        </Select>
                        <Button className="flex-1">Confirm</Button>
                    </div>
                </div>
            </div>
        </section>
    );
}
export default BookAppointment;